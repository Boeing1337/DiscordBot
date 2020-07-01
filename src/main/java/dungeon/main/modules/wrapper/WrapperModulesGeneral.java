package dungeon.main.modules.wrapper;

import dungeon.main.modules.general.clean.core.Cleaner;
import dungeon.main.modules.general.coinFlip.core.CoinFlipper;
import dungeon.main.modules.general.roll.core.Roller;
import dungeon.main.modules.interfaces.ModuleGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class WrapperModulesGeneral extends HashMap<String, ModuleGeneral> {
    WrapperModulesGeneral(@Autowired Cleaner cleaner, Roller roller, CoinFlipper coinFlipper) {
        this.put("`roll", roller);
        this.put("`clean", cleaner);
        this.put("`flip", coinFlipper);
    }
}
