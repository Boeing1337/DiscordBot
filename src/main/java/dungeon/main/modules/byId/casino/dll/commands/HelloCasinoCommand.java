package dungeon.main.modules.byId.casino.dll.commands;

import dungeon.main.modules.byId.casino.dll.commands.interfaces.CasinoCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class HelloCasinoCommand implements CasinoCommand {

    @Override
    public void run(MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("You are welcome " + event.getAuthor().getAsMention()).complete();

    }
}