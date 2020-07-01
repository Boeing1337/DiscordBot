package dungeon.main.modules.general.clean.dll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CleanValueRetrieverTest {

    @Test
    void retrieve() {
        CleanValueRetriever cleanValueRetriever = new CleanValueRetriever();
        assertEquals(0, cleanValueRetriever.retrieve("`clean"));
    }

    @Test
    void retrieve2() {
        CleanValueRetriever cleanValueRetriever = new CleanValueRetriever();
        assertEquals(0, cleanValueRetriever.retrieve("`clean "));
    }

    @Test
    void retrieve3() {
        CleanValueRetriever cleanValueRetriever = new CleanValueRetriever();
        assertEquals(0, cleanValueRetriever.retrieve("`clean  "));
    }

    @Test
    void retrieve4() {
        CleanValueRetriever cleanValueRetriever = new CleanValueRetriever();
        assertEquals(1, cleanValueRetriever.retrieve("`clean 1"));
    }


    @Test
    void retrieve5() {
        CleanValueRetriever cleanValueRetriever = new CleanValueRetriever();
        assertEquals(5, cleanValueRetriever.retrieve("`clean 5"));
    }
}