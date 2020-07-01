package dungeon.main.modules.byId.casino.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class CasinoPlayer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String userName;
    private Long score;
    private Long bet;

    {
        userName = "not userName";
        score = 250L;
        bet = 5L;
    }

    public CasinoPlayer() {

    }

    public CasinoPlayer(String userName) {
        this.userName = userName;
    }

}
