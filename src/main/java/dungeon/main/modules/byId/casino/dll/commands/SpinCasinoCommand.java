package dungeon.main.modules.byId.casino.dll.commands;

import dungeon.main.modules.byId.casino.dao.CasinoPlayer;
import dungeon.main.modules.byId.casino.dao.CasinoPlayerDAO;
import dungeon.main.modules.byId.casino.dll.cards.interfaces.Card;
import dungeon.main.modules.byId.casino.dll.cards.wrapper.ListCards;
import dungeon.main.modules.byId.casino.dll.commands.interfaces.CasinoCommand;
import dungeon.main.modules.byId.casino.dll.other.SentData;
import dungeon.main.modules.byId.casino.dll.other.WinPossibles;
import dungeon.main.modules.byId.casino.util.ImageCreator;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class SpinCasinoCommand implements CasinoCommand {

    private final List<Card> listCards;
    private final CasinoPlayerDAO playerDAO;
    private final ImageCreator imageCreator;

    private String userName = null;
    private TextChannel textChannel = null;
    private String mention = null;

    public SpinCasinoCommand(@Autowired ListCards listCards, CasinoPlayerDAO playerDAO,
                             ImageCreator imageCreator) {

        this.listCards = listCards;
        this.playerDAO = playerDAO;
        this.imageCreator = imageCreator;
    }


    @Override
    public void run(MessageReceivedEvent event) {
        prepareData(event);
        if (isUserExist()) {
            if (isCanSpin()) {
                spinTo();
            } else {
                sendTooBigBet();
            }
        }
        clearData();
    }

    private boolean isUserExist() {
        return playerDAO.existsByUserName(userName);
    }

    private boolean isCanSpin() {
        CasinoPlayer casinoPlayer = playerDAO.getUser(userName);
        return casinoPlayer.getScore() >= casinoPlayer.getBet();
    }

    private void spinTo() {
        CasinoPlayer casinoPlayer = playerDAO.getUser(userName);
        List<Card> cardList = generateRawSpinValue();
        SentData sentData = generateSentData(cardList);
        File file = imageCreator.createSpinImage(cardList);

        sentData.setUserData(casinoPlayer);
        sentData.setMention(mention);
        changeUserData(casinoPlayer, sentData);
        sendResults(sentData, file);
    }

    private void changeUserData(CasinoPlayer casinoPlayer, SentData sentData) {

        casinoPlayer.setScore(casinoPlayer.getScore() - casinoPlayer.getBet() + sentData.getWonValue());
        playerDAO.update(casinoPlayer);
    }


    private SentData generateSentData(List<Card> listCards) {
        SentData sentData = new SentData();
        WinPossibles winPossibles = rowCheck(listCards);

        if (winPossibles.isSlotPossible()) {
            sentData.setEventType("BEYOND GODLIKE!YOU ARE VERY LUCKY!!!");
            sentData.setWonValue((int)
            Math.pow(listCards.stream().mapToInt(Card::getValue).min().getAsInt() * 13, 4));

        } else if (winPossibles.isRowPossible()) {
            sentData.setEventType("Four in a ROW!!!");
            sentData.setWonValue((int)
            Math.pow(listCards.stream().mapToInt(Card::getValue).min().getAsInt(), 4));

        } else if (winPossibles.isPrimePossible()) {
            sentData.setEventType("Cheap lucky!");
            sentData.setWonValue(listCards.stream().mapToInt(Card::getValue).sum());
        }
        return sentData;
    }

    private WinPossibles rowCheck(List<Card> cardList) {
        if (isLuckySlot(cardList))
            return new WinPossibles(false, false, true);

        boolean rowPossible = true;
        boolean primePossible = true;

        List<Card> tempList = new ArrayList<>(cardList);
        tempList.sort(Comparator.naturalOrder());

        for (int i = 0; i < tempList.size() - 1; i++) {
            if (!rowPossible && !primePossible)
                break;

            Card tempCard = tempList.get(i);

            if (tempCard.isJoker())
                break;

            if (tempCard.compareTo(tempList.get(i + 1)) < 0
            && !tempList.get(i + 1).isJoker()) {
                rowPossible = false;
            }

            if (!tempCard.isPrime() || !tempList.get(i + 1).isPrime())
                primePossible = false;
        }

        return new WinPossibles(rowPossible, primePossible, false);
    }

    private boolean isLuckySlot(List<Card> tempList) {
        return tempList.get(0).getValue() == 11 &&
        tempList.get(1).getValue() == 12 &&
        tempList.get(2).getValue() == 13 &&
        tempList.get(3).getValue() == 14;
    }

    private List<Card> generateRawSpinValue() {
        List<Card> listCards = new ArrayList<>();

        int tempCard;
        do {
            tempCard = (int) (Math.random() * 12);
        } while (tempCard == 11 || tempCard == 10 || tempCard == 9);
        listCards.add(this.listCards.get(tempCard));

        do {
            tempCard = (int) (Math.random() * 12);
        } while (tempCard == 11 || tempCard == 10 || tempCard == 8);
        listCards.add(this.listCards.get(tempCard));

        do {
            tempCard = (int) (Math.random() * 12);
        } while (tempCard == 11 || tempCard == 9 || tempCard == 8);
        listCards.add(this.listCards.get(tempCard));

        do {
            tempCard = (int) (Math.random() * 12);
        } while (tempCard == 10 || tempCard == 9 || tempCard == 8);
        listCards.add(this.listCards.get(tempCard));

        return listCards;
    }


    private void prepareData(MessageReceivedEvent event) {
        this.textChannel = event.getTextChannel();
        this.userName = event.getAuthor().getName();
        this.mention = event.getAuthor().getAsMention();

    }

    private void clearData() {
        this.textChannel = null;
        this.userName = null;
    }

    private void sendResults(SentData sentData, File file) {
        textChannel.sendMessage(sentData.build()).addFile(file).complete();
    }

    private void sendTooBigBet() {
        textChannel.sendMessage("Sorry! " + userName + ", you don't have enough cheeps!").complete();
    }

}
