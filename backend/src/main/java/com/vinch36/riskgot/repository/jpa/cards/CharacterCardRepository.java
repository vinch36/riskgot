package com.vinch36.riskgot.repository.jpa.cards;

import com.vinch36.riskgot.model.game.cards.CharacterCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterCardRepository extends CrudRepository<CharacterCard, Long> {

}
