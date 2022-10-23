package com.vinch36.riskgot.repository.jpa.cards;

import com.vinch36.riskgot.model.game.cards.TerritoryCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritoryCardRepository extends CrudRepository<TerritoryCard, Long> {

}
