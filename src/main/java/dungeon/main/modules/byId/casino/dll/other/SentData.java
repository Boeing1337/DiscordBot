package dungeon.main.modules.byId.casino.dll.other;

import dungeon.main.modules.byId.casino.dao.CasinoPlayer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SentData {
    private String eventType = "Unlucky. Do you wanna try again?";
    private int wonValue = 0;
    private Long bet = 5L;
    private Long pastScore;
    private String mention;

    public String build() {
        return
        mention + " you won: " + getWonValue() + "\n" +
        getEventType() + "\n" +
        "bet: " + getBet() + " | " + pastScore + " -> " + (pastScore - getBet() + getWonValue());
    }

    public void setUserData(CasinoPlayer casinoPlayer) {
        bet = casinoPlayer.getBet();
        pastScore = casinoPlayer.getScore();
    }
}
