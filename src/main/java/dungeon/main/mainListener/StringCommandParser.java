package dungeon.main.mainListener;

import org.springframework.stereotype.Component;

@Component
public class StringCommandParser {
    private final int MAX_COMMAND_LENGHT = 10;
    private final String PREF = "`";

    public String parse(String rawString) {
        if (rawString.length() <= MAX_COMMAND_LENGHT && rawString.startsWith(PREF))
            return cut(rawString);
        return "";
    }

    private String cut(String string) {
        return string.trim().split("\\h")[0];
    }
}
