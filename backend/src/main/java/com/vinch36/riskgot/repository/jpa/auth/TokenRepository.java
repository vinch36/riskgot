package com.vinch36.riskgot.repository.jpa.auth;

import com.vinch36.riskgot.model.auth.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository  extends CrudRepository<Token, Long> {
}
