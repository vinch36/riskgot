package com.vinch36.riskgot.repository.jpa;

import com.vinch36.riskgot.model.game.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
