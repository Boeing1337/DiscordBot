package dungeon.main.modules.byId.casino.dll.cards;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SixCardTest {

    @Test
    public void getValue() {
        assertEquals(6, new SixCard().getValue());
    }

    @Test
    public void isPrime() {
        assertFalse(new SixCard().isPrime());
    }

    @Test
    public void getName() {
        assertEquals("Six", new SixCard().getName());
    }
}