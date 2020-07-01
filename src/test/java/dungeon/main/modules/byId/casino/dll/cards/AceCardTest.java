package dungeon.main.modules.byId.casino.dll.cards;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AceCardTest {

    @Test
    public void getValue() {
        assertEquals(25, new AceCard().getValue());
    }

    @Test
    public void isPrime() {
        assertTrue(new AceCard().isPrime());
    }

    @Test
    public void getName() {
        assertEquals("Ace", new AceCard().getName());
    }

    @Test
    void compareTo() {

    }
}