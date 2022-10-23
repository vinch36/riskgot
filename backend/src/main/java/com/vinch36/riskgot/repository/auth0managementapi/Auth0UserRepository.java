package com.vinch36.riskgot.repository.auth0managementapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.istack.NotNull;
import com.vinch36.riskgot.model.auth.Token;
import com.vinch36.riskgot.model.auth.User;
import com.vinch36.riskgot.repository.auth0managementapi.requestobjects.UserRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Auth0UserRepository {
    public Token getTokenFromAuth0(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // request body parameters
        Map<String, Object> map = new HashMap<>();
        map.put("client_id", "tiUMF5I3QYl9ugWXu7HVsbarNxrOCMyD");
        map.put("client_secret", "ctpzHDVGsjr2AYphGJKO_XJb1-9AQ4r3iMmHC_XB4CNk_sSgl8botLx_GeE6Nmsj");
        map.put("audience", "https://dev-9-9s2dzx.us.auth0.com/api/v2/");
        map.put("grant_type", "client_credentials");

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);


        String url = "https://dev-9-9s2dzx.us.auth0.com/oauth/token";
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("New Access Token Request Successful");
            System.out.println(response.getBody());
        } else {
            System.out.println("New Token Request Failed");
            System.out.println(response.getStatusCode());
        }

        ObjectMapper mapper = new ObjectMapper();
        Token token = null;
        try {
            token = mapper.readValue(response.getBody(), Token.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        token.setValid_untilFromInnerAccessToken();

        return token;
    }


    public User getUserFromAuth0(String userSub, Token token)  {



        RestTemplate restTemplateGet = new RestTemplate();
        HttpHeaders headersGet = new HttpHeaders();
        // set `content-type` header
        headersGet.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headersGet.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // request body parameters
        headersGet.setBearerAuth(token.getAccess_token());

        // build the request
        HttpEntity<String> entityGet = new HttpEntity<>("", headersGet);

        String urlGet = "https://dev-9-9s2dzx.us.auth0.com/api/v2/users/"+userSub;
        ResponseEntity<String> responseGet = restTemplateGet.exchange(urlGet,HttpMethod.GET, entityGet, String.class);

        if (responseGet.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
            System.out.println(responseGet.getBody());
        } else {
            System.out.println("Request Failed");
            System.out.println(responseGet.getStatusCode());
        }

        ObjectMapper mapperGet = new ObjectMapper();
        User user;
        try {
            user = mapperGet.readValue(responseGet.getBody(), User.class);
        } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
        }
        System.out.println("EMAIL = " + user.getEmail() + " - AUTH0 USER_ID =  "+user.getUser_id());

        return user;

    }

    public void updateUserOnAuth0(User user, @NotNull Token token)
    {
        RestTemplate restTemplateGet = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // request body parameters
        headers.setBearerAuth(token.getAccess_token());

        UserRequest us = new UserRequest(user);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonBody;
        try {
            jsonBody = ow.writeValueAsString(us);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // build the request
        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);


        String url = "https://dev-9-9s2dzx.us.auth0.com/api/v2/users/"+user.getUser_id();
        ResponseEntity<String> responsePatch = restTemplateGet.exchange(url,HttpMethod.PATCH, entity, String.class);

        if (responsePatch.getStatusCode() == HttpStatus.OK) {
            System.out.println("PATCH USER ON AUTH0 Successful");
            System.out.println(responsePatch.getBody());
        } else {
            System.out.println("PATCH USER ON AUTH0 Failed");
            System.out.println(responsePatch.getStatusCode());
        }
    }
}
