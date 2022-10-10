package com.vinch36.riskgot.repository;

import com.vinch36.riskgot.model.Player;
import com.vinch36.riskgot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
