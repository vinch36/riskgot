package com.vinch36.riskgot.repository.jpa.auth;

import com.vinch36.riskgot.model.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {


}
