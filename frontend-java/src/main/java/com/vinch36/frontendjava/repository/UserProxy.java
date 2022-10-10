package com.vinch36.frontendjava.repository;

import com.vinch36.frontendjava.configuration.CustomProperties;
import com.vinch36.frontendjava.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class UserProxy {
    @Autowired
    private CustomProperties props;

    /**
     * Get all users
     * @return An iterable of all users
     */

    public Iterable<User> getUsers() {
        String baseApiUrl = props.getApiUrl();
        String getUserUrl = baseApiUrl + "/user";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<User>> response = restTemplate.exchange(
                getUserUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<User>>() {}
        );

        log.info("Get Users call " + response.getStatusCode().toString());

        return response.getBody();
    }



    public User getUser(Integer id) {
        String baseApiUrl = props.getApiUrl();
        String getUserUrl = baseApiUrl + "/user/"+id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.exchange(
                getUserUrl,
                HttpMethod.GET,
                null,
                User.class
        );

        log.info("Get User call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public User createUser(User u) {
        String baseApiUrl = props.getApiUrl();
        String createUserUrl = baseApiUrl + "/user";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<User>(u);
        ResponseEntity<User> response = restTemplate.exchange(
                createUserUrl,
                HttpMethod.POST,
                request,
                User.class);

        log.debug("Create User call " + response.getStatusCode().toString());

        return response.getBody();
    }


    /**
     * Update a user - using the PUT HTTP Method.
     * @param u Existing employee to update
     */
    public User updateUser(User u) {
        String baseApiUrl = props.getApiUrl();
        String updateUserUrl = baseApiUrl + "/user/" + u.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<User>(u);
        ResponseEntity<User> response = restTemplate.exchange(
                updateUserUrl,
                HttpMethod.PUT,
                request,
                User.class);

        log.debug("Update User call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete a user using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The user to delete
     */
    public void deleteUser(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteUserUrl = baseApiUrl + "/user/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUserUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete User call " + response.getStatusCode().toString());
    }
}
