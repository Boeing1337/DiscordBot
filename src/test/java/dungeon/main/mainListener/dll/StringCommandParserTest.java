package dungeon.main.mainListener.dll;

import dungeon.main.mainListener.StringCommandParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCommandParserTest {

    @Test
    void parse() {
        StringCommandParser l = new StringCommandParser();
        assertEquals("`123456789", l.parse("`123456789"));
    }

    @Test
    void parse2() {
        StringCommandParser l = new StringCommandParser();
        assertEquals("", l.parse("`12345678910"));
    }

    @Test
    void parse3() {
        StringCommandParser l = new StringCommandParser();
        assertEquals("", l.parse("`12345678910"));
    }
}