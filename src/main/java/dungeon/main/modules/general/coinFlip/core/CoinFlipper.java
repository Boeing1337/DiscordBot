package dungeon.main.modules.general.coinFlip.core;

import dungeon.main.modules.general.coinFlip.dll.CoinMsgRetrieve;
import dungeon.main.modules.interfaces.ModuleGeneral;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinFlipper implements ModuleGeneral {
    private final static String[] coinSides = {"Воробей", "орешек"};
    private final CoinMsgRetrieve coinMsgRetrieve;

    private TextChannel textChannel;
    private String rawMsg;
    private String authorMention;

    CoinFlipper(@Autowired CoinMsgRetrieve coinMsgRetrieve) {
        this.coinMsgRetrieve = coinMsgRetrieve;
    }

    @Override
    public void run(MessageReceivedEvent event) {
        prepareData(event);
        sendMessageByRetrieve();
    }

    private void sendMessageByRetrieve() {
        if (coinMsgRetrieve.retrieve(rawMsg)) {
            sendCoinSide();
        } else {
            sendError();
        }
    }

    private void sendCoinSide() {
        int point = (int) (Math.random() * 2);
        textChannel.sendMessage(authorMention + ", your flip: " + coinSides[point]).complete();
    }

    private void sendError() {
        textChannel.sendMessage(authorMention + ", no arguments please").complete();
    }

    private void prepareData(MessageReceivedEvent event) {
        textChannel = event.getTextChannel();
        authorMention = event.getAuthor().getAsMention();
        rawMsg = event.getMessage().getContentRaw();
    }
}
