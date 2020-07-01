package dungeon.main.modules.general.coinFlip.dll;

import org.springframework.stereotype.Component;

@Component
public class CoinMsgRetrieve {
    private final static int COMMAND_LENGTH = 5;

    private String temp;

    public boolean retrieve(String raw) {
        parseRaw(raw);
        return temp.isEmpty();
    }

    private void parseRaw(String raw) {
        temp = raw.substring(COMMAND_LENGTH).trim();
    }
}
