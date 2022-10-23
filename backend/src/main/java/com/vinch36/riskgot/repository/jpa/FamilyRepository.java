package com.vinch36.riskgot.repository.jpa;

import com.vinch36.riskgot.model.game.Family;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Long> {

}
