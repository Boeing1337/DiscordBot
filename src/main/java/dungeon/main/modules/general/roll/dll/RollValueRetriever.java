package dungeon.main.modules.general.roll.dll;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class RollValueRetriever {
    private final static Pattern digits = Pattern.compile("\\d+");
    private final static int COMMAND_LENGTH = 5;

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
