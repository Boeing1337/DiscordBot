package dungeon.main.modules.general.clean.dll;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class CleanValueRetriever {
    private final static Pattern digits = Pattern.compile("\\d{1,2}");
    private final static int COMMAND_LENGTH = 6;

    private String temp;

    public int retrieve(String raw) {
        parseRaw(raw);
        return returnByMach();
    }

    private int returnByMach() {
        if (digits.matcher(temp).matches()) {
            return Integer.parseInt(temp);
        } else {
            return 0;
        }
    }

    private void parseRaw(String raw) {
        temp = raw.substring(COMMAND_LENGTH).trim();
    }
}
