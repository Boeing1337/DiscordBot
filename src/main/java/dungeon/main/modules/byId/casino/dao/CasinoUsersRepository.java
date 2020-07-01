package dungeon.main.modules.byId.casino.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasinoUsersRepository extends CrudRepository<CasinoPlayer, Long> {
    boolean existsByUserName(String userName);
    CasinoPlayer getByUserName(String userName);
    List<CasinoPlayer> getTop10ByOrderByScore();
}
