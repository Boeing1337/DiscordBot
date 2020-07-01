package dungeon.main.modules.byId.casino.dll.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValetCardTest {

    @Test
    public void getValue() {
        assertEquals(15, new ValetCard().getValue());
    }

    @Test
    public void isPrime() {
        assertTrue(new ValetCard().isPrime());
    }

    @Test
    public void getName() {
        assertEquals("Valet", new ValetCard().getName());
    }
}