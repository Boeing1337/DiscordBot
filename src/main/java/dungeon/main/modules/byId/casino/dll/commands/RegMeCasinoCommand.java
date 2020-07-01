package dungeon.main.modules.byId.casino.dll.commands;

import dungeon.main.modules.byId.casino.dao.CasinoPlayerDAO;
import dungeon.main.modules.byId.casino.dll.commands.interfaces.CasinoCommand;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegMeCasinoCommand implements CasinoCommand {

    private final CasinoPlayerDAO playerDAO;

    public RegMeCasinoCommand(@Autowired CasinoPlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }


    private void sendRegistrationSuccessful(TextChannel textChannel, String userName) {
        textChannel.sendMessage(userName + " your registration is successful!").complete();
    }

    private void sendRegistrationFailed(TextChannel textChannel, String userName) {
        textChannel.sendMessage("Sorry! Registration is failed, " + userName).complete();
    }

    private boolean registrate(String userName) {
        return playerDAO.registrate(userName);
    }

    @Override
    public void run(MessageReceivedEvent event) {
        String userName = event.getAuthor().getName();
        TextChannel textChannel = event.getTextChannel();

        if (registrate(userName)) {
            sendRegistrationSuccessful(textChannel, userName);
        } else {
            sendRegistrationFailed(textChannel, userName);
        }
    }
}
