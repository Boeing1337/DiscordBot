package dungeon.main.modules.general.roll.dll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RollValueRetrieverTest {

    @Test
    void retrieveRoll() {
        RollValueRetriever rollValueRetriever = new RollValueRetriever();
        assertEquals(0, rollValueRetriever.retrieve("`roll"));
    }
    @Test
    void retrieveRolls() {
        RollValueRetriever rollValueRetriever = new RollValueRetriever();
        assertEquals(0, rollValueRetriever.retrieve("`roll "));
    }

    @Test
    void retrieveRollsDf() {
        RollValueRetriever rollValueRetriever = new RollValueRetriever();
        assertEquals(1, rollValueRetriever.retrieve("`roll 1"));
    }

    @Test
    void retrieveRollsDt() {
        RollValueRetriever rollValueRetriever = new RollValueRetriever();
        assertEquals(5, rollValueRetriever.retrieve("`roll 5"));
    }
}