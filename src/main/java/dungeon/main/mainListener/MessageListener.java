package dungeon.main.mainListener;


import dungeon.main.modules.wrapper.WrapperModulesById;
import dungeon.main.modules.wrapper.WrapperModulesGeneral;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Component
public class MessageListener extends ListenerAdapter {
    private final WrapperModulesById wrapperModulesById;
    private final WrapperModulesGeneral wrapperModulesGeneral;
    private final StringCommandParser stringCommandParser;

    private String command;
    private String channelId;

    public MessageListener(@Autowired WrapperModulesById wrapperModulesById,
                           WrapperModulesGeneral wrapperModulesGeneral,
                           StringCommandParser stringCommandParser) {

        this.wrapperModulesById = wrapperModulesById;
        this.wrapperModulesGeneral = wrapperModulesGeneral;
        this.stringCommandParser = stringCommandParser;
    }

    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        prepareMsgAndId(event);
        if (wrapperModulesGeneral.containsKey(command)) {
            wrapperModulesGeneral.get(command).run(event);
        } else if (wrapperModulesById.containsKey(channelId)) {
            wrapperModulesById.get(channelId).run(event);
        }

    }

    private void prepareMsgAndId(MessageReceivedEvent event) {
        command = stringCommandParser.parse(event.getMessage().getContentRaw());
        channelId = event.getChannel().getId();
    }

}
