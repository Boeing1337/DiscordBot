package dungeon.main.modules.byId.casino.dll.cards;

import dungeon.main.modules.byId.casino.dll.cards.interfaces.Card;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class FiveCard implements Card {
    final private static int VALUE = 5;
    final private static boolean PRIME = false;
    final private static String NAME = "Five";

    @Override
    public int getValue() {
        return VALUE;
    }

    @Override
    public boolean isPrime() {
        return PRIME;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean isJoker() {
        return false;
    }

    @Override
    public int compareTo(@NotNull Card o) {
        return Integer.compare(VALUE, o.getValue());
    }
}
