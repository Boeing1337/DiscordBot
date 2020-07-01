package dungeon.main.modules.byId.casino.dll.cards.wrapper;

import dungeon.main.modules.byId.casino.dll.cards.*;
import dungeon.main.modules.byId.casino.dll.cards.interfaces.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListCards extends ArrayList<Card> {
    ListCards(@Autowired AceCard aceCard, FiveCard fiveCard,
              FourCard fourCard, JokerCard jokerCard, KingCard kingCard,
              SixCard sixCard, ThreeCard threeCard, ValetCard valetCard,
              SCard sCard, LCard lCard, OCard oCard, TCard tCard) {

        this.add(jokerCard);
        this.add(aceCard);
        this.add(kingCard);
        this.add(valetCard);
        this.add(sixCard);
        this.add(fiveCard);
        this.add(fourCard);
        this.add(threeCard);
        this.add(sCard);
        this.add(lCard);
        this.add(oCard);
        this.add(tCard);
    }
}
