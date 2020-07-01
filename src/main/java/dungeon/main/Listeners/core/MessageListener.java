package dungeon.main.Listeners.core;


import dungeon.main.Listeners.dll.ListenerStringParser;
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
    private final ListenerStringParser listenerStringParser;

    private String firsWord;
    private String channelId;

    public MessageListener(@Autowired WrapperModulesById wrapperModulesById,
                           WrapperModulesGeneral wrapperModulesGeneral,
                           ListenerStringParser listenerStringParser) {

        this.wrapperModulesById = wrapperModulesById;
        this.wrapperModulesGeneral = wrapperModulesGeneral;
        this.listenerStringParser = listenerStringParser;
    }

    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        prepareMsgAndId(event);
        if (wrapperModulesGeneral.containsKey(firsWord)) {
            wrapperModulesGeneral.get(firsWord).run(event);
        } else if (wrapperModulesById.containsKey(channelId)) {
            wrapperModulesById.get(channelId).run(event);
        }

    }

    private void prepareMsgAndId(MessageReceivedEvent event) {
        firsWord = listenerStringParser.parse(event.getMessage().getContentRaw());
        channelId = event.getChannel().getId();
    }

}
