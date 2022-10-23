package com.vinch36.riskgot.service.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vinch36.riskgot.model.auth.Token;
import com.vinch36.riskgot.model.auth.User;
import com.vinch36.riskgot.repository.auth0managementapi.Auth0UserRepository;
import com.vinch36.riskgot.repository.jpa.auth.TokenRepository;
import com.vinch36.riskgot.repository.jpa.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {


    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private Auth0UserRepository auth0UserRepository;

    @Autowired
    private UserRepository userRepository;
    public Token getToken()
    {
        //first check in DB if we have one token available still valid.
        Iterable<Token> tokens = tokenRepository.findAll();

        for (Token t:tokens)
        {
            if (t.isValid()){
                return t;
            }
        }

        //No token found in DB, we need to ask for a new one and we save it in the database
        Token newToken =  auth0UserRepository.getTokenFromAuth0();
        return tokenRepository.save(newToken);
    }











   public User getUserFromAuth0(String userSub){
       User user = auth0UserRepository.getUserFromAuth0(userSub, this.getToken());
       return userRepository.save(user);
   }


    public Optional<User>   getUser(final String email){
        return userRepository.findById(email);
    }



    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(final String email){
        userRepository.deleteById(email);
    }

    public User saveUser(User user){
        User savedUser=userRepository.save(user);

        auth0UserRepository.updateUserOnAuth0(savedUser, this.getToken());
        return savedUser;
    }








}
