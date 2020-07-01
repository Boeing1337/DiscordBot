package dungeon.main.modules.byId.casino.dll.cards;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ThreeCardTest {

    @Test
    public void getValue() {
        assertEquals(3, new ThreeCard().getValue());
    }

    @Test
    public void isPrime() {
        assertFalse(new ThreeCard().isPrime());
    }

    @Test
    public void getName() {
        assertEquals("Three", new ThreeCard().getName());
    }
}