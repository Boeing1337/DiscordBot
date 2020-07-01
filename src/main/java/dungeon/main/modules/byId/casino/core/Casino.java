package dungeon.main.modules.byId.casino.core;

import dungeon.main.modules.byId.casino.dll.commands.interfaces.CasinoCommand;
import dungeon.main.modules.byId.casino.dll.commands.wrapper.MapCommands;
import dungeon.main.modules.interfaces.ModuleById;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Casino implements ModuleById {

    private final MapCommands mapCommands;

    public Casino(@Autowired MapCommands mapCommands) {
        this.mapCommands = mapCommands;
    }

    public synchronized void run(MessageReceivedEvent event) {

        String msg = event.getMessage().getContentRaw().trim();

        CasinoCommand casinoCommand = mapCommands.get(msg);
        if (casinoCommand != null)
            casinoCommand.run(event);

    }

}

