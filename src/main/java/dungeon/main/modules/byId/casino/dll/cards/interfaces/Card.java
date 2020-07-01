package dungeon.main.modules.byId.casino.dll.cards.interfaces;

public interface Card extends Comparable<Card> {

    int getValue();

    boolean isPrime();

    String getName();

    boolean isJoker();

}
