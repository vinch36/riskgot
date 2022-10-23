package com.vinch36.riskgot.repository.jpa.cards;

import com.vinch36.riskgot.model.game.cards.GoalCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalCardRepository extends CrudRepository<GoalCard, Long> {

}
