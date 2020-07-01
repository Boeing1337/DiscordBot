package dungeon.main.modules.wrapper;

import dungeon.main.modules.byId.casino.core.Casino;
import dungeon.main.modules.interfaces.ModuleById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class WrapperModulesById extends HashMap<String, ModuleById> {
    public WrapperModulesById(@Autowired Casino casino) {
        this.put("689135288454611044", casino);
        this.put("689913729143668766", casino);
    }
}
