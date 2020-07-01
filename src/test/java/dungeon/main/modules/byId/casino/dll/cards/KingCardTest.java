package dungeon.main.modules.byId.casino.dll.cards;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingCardTest {

    @Test
    public void getValue() {
        assertEquals(20, new KingCard().getValue());
    }

    @Test
    public void isPrime() {
        assertTrue(new KingCard().isPrime());
    }

    @Test
    public void getName() {
        assertEquals("King", new KingCard().getName());
    }
}