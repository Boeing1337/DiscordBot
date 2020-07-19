package dungeon.main.modules.byId.casino.dll.commands;

import dungeon.main.modules.byId.casino.dao.CasinoPlayer;
import dungeon.main.modules.byId.casino.dao.CasinoPlayerDAO;
import dungeon.main.modules.byId.casino.dll.commands.interfaces.CasinoCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Component
public class LadderCasinoCommand implements CasinoCommand {
    private CasinoPlayerDAO playerDAO;

    public LadderCasinoCommand(@Autowired CasinoPlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    public void run(MessageReceivedEvent event) {
        List<CasinoPlayer> list = playerDAO.getTop10();
        list.sort((a, b) -> Long.compare(b.getScore(), a.getScore()));

        EmbedBuilder Header = new EmbedBuilder();
        Header.setColor(Color.pink);
        Header.setAuthor("Varan's ladder");
        Header.setTitle("LADDER TOP 10");
        Header.setFooter("По всем вопросам в личку");
        StringBuilder s = new StringBuilder();
        list.forEach(p -> s.append(p.getUserName()).append("ᅠᅠᅠ").append(p.getScore()).append("\n"));
        Header.setDescription(s.toString());
        event.getTextChannel().sendMessage(Header.build()).complete();
    }
}
