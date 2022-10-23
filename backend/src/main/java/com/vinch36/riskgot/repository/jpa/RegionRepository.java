package com.vinch36.riskgot.repository.jpa;

import com.vinch36.riskgot.model.game.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {

}
