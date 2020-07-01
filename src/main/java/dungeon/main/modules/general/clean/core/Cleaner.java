package dungeon.main.modules.general.clean.core;

import dungeon.main.modules.general.clean.dll.CleanValueRetriever;
import dungeon.main.modules.interfaces.ModuleGeneral;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cleaner implements ModuleGeneral {
    private final static int SELF_MESSAGE = 1;
    private final static int MAX_COUNT = 99;
    private final static int MIN_COUNT = 1;
    private final CleanValueRetriever cleanValueRetriever;

    private TextChannel textChannel;
    private Member member;
    private String rawMsg;
    private int messagesCount;

    Cleaner(@Autowired CleanValueRetriever cleanValueRetriever) {
        this.cleanValueRetriever = cleanValueRetriever;
    }

    public void run(MessageReceivedEvent event) {
        prepareData(event);
        if (!isUserHavePrivileges())
            return;
        retrieveMessageCount();
        checkAndProcess();
    }

    private void checkAndProcess() {
        if (isCountInRange()) {
            deleteByCount();
        } else {
            sendErrorMessage();
        }
    }


    private boolean isUserHavePrivileges() {
        return member.isOwner() || member.getId().equals("256722804093747200");
    }

    private boolean isCountInRange() {
        return messagesCount <= MAX_COUNT && messagesCount >= MIN_COUNT;
    }

    private void sendErrorMessage() {
        textChannel.sendMessage("You need print [`clean x];\nx = value from 1 to 99").complete();
    }

    private void deleteByCount() {
        textChannel.deleteMessages(textChannel.getHistory().retrievePast(messagesCount + SELF_MESSAGE)
        .complete()).complete();
    }

    private void retrieveMessageCount() {
        messagesCount = cleanValueRetriever.retrieve(rawMsg);
    }

    private void prepareData(MessageReceivedEvent event) {
        member = event.getMember();
        textChannel = event.getTextChannel();
        rawMsg = event.getMessage().getContentRaw();
    }

}
