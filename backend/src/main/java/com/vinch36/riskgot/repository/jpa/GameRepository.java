package com.vinch36.riskgot.repository.jpa;

import com.vinch36.riskgot.model.game.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

}
