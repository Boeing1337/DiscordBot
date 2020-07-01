package dungeon.main.modules.byId.casino.dll.commands.wrapper;

import dungeon.main.modules.byId.casino.dll.commands.HelloCasinoCommand;
import dungeon.main.modules.byId.casino.dll.commands.LadderCasinoCommand;
import dungeon.main.modules.byId.casino.dll.commands.RegMeCasinoCommand;
import dungeon.main.modules.byId.casino.dll.commands.SpinCasinoCommand;
import dungeon.main.modules.byId.casino.dll.commands.interfaces.CasinoCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MapCommands extends HashMap<String, CasinoCommand> {

    public MapCommands(@Autowired HelloCasinoCommand helloCommand,
                       SpinCasinoCommand spinCommand,
                       RegMeCasinoCommand regMeCommand,
                       LadderCasinoCommand ladderCommand) {

        this.put("Hello", helloCommand);
        this.put("Spin", spinCommand);
        this.put("Reg me", regMeCommand);
        this.put("Ladder", ladderCommand);
    }
}
