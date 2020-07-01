package dungeon.main.modules.byId.casino.dll.cards;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JokerCardTest {

    @Test
    public void getValue() {
        assertEquals(50, new JokerCard().getValue());
    }

    @Test
    public void isPrime() {
        assertTrue(new JokerCard().isPrime());
    }

    @Test
    public void getName() {
        assertEquals("Joker", new JokerCard().getName());
    }
}