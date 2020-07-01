package dungeon.main.modules.byId.casino.dll.cards;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class FourCardTest {

    @Test
    public void getValue() {
        assertEquals(4, new FourCard().getValue());
    }

    @Test
    public void isPrime() {
        assertFalse(new FourCard().isPrime());
    }

    @Test
    public void getName() {
        assertEquals("Four", new FourCard().getName());
    }
}