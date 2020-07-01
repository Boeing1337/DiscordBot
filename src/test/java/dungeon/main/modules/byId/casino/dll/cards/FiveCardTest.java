package dungeon.main.modules.byId.casino.dll.cards;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class FiveCardTest {

    @Test
    public void getValue() {
        assertEquals(5, new FiveCard().getValue());
    }

    @Test
    public void isPrime() {
        assertFalse(new FiveCard().isPrime());
    }

    @Test
    public void getName() {
        assertEquals("Five", new FiveCard().getName());
    }
}