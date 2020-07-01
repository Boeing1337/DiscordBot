package dungeon.main.modules.general.roll.core;

import dungeon.main.modules.general.roll.dll.RollValueRetriever;
import dungeon.main.modules.interfaces.ModuleGeneral;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Roller implements ModuleGeneral {
    private final RollValueRetriever rollValueRetriever;

    private TextChannel textChannel;
    private String authorMention;
    private String rawMsg;
    private int value;

    Roller(@Autowired RollValueRetriever rollValueRetriever) {
        this.rollValueRetriever = rollValueRetriever;
    }

    public void run(MessageReceivedEvent event) {
        prepareData(event);
        getDiceValue();
        checkAndSend();
    }

    private void checkAndSend() {
        if (value < 2) {
            sendErrorMessage();
        } else {
            rollAndSendMessage();
        }
    }

    private void prepareData(MessageReceivedEvent event) {
        textChannel = event.getTextChannel();
        authorMention = event.getAuthor().getAsMention();
        rawMsg = event.getMessage().getContentRaw();
    }

    private void getDiceValue() {
        value = rollValueRetriever.retrieve(rawMsg);
    }

    private int generateRollValue() {
        return (int) (Math.random() * value);
    }

    private void rollAndSendMessage() {
        textChannel.sendMessage(authorMention + ", Your roll is: " + generateRollValue())
        .complete();
    }

    private void sendErrorMessage() {
        textChannel.sendMessage(authorMention + " you sent illegal value")
        .complete();
    }
}
