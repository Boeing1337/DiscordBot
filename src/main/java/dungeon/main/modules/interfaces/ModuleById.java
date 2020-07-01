package dungeon.main.modules.interfaces;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface ModuleById {
    void run(MessageReceivedEvent event);
}
