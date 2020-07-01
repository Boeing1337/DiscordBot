package dungeon.main.modules.byId.casino.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CasinoPlayerDAO {

    private CasinoUsersRepository usersRep;

    public CasinoPlayerDAO(@Autowired CasinoUsersRepository usersRep) {
        this.usersRep = usersRep;
    }

    public boolean existsByUserName(String userName) {
        return usersRep.existsByUserName(userName);
    }

    public boolean registrate(String userName) {
        if (existsByUserName(userName))
            return false;

        usersRep.save(new CasinoPlayer(userName));
        return true;
    }

    public long getScore(String userName) {
        return getUser(userName).getScore();
    }

    public long getBet(String userName) {
        return getUser(userName).getBet();
    }

    public CasinoPlayer getUser(String userName) {
        return usersRep.getByUserName(userName);
    }

    public void update(CasinoPlayer casinoPlayer) {
        usersRep.save(casinoPlayer);
    }

    public List<CasinoPlayer> getTop10() {
        return usersRep.getTop10ByOrderByScore();
    }
}
