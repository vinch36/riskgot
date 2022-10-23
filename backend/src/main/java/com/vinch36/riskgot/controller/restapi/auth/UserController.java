package com.vinch36.riskgot.controller.restapi.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vinch36.riskgot.model.auth.User;
import com.vinch36.riskgot.model.game.Family;
import com.vinch36.riskgot.model.game.Game;
import com.vinch36.riskgot.model.game.Player;
import com.vinch36.riskgot.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private AuthService authService;






    @PostMapping("/login")
    public User login(@AuthenticationPrincipal Jwt principal){
            return authService.getUserFromAuth0(principal.getClaimAsString("sub"));

        }


    /**
     * Read - Get all users
     * @return - An Iterable object of User
     */
    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return authService.getUsers();
    }

    /**
     * Read - Get one employee
     * @param email The email  of the user
     * @return An User object full filled
     */
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") final String email) {
        Optional<User> u = authService.getUser(email);
        if(u.isPresent()) {
            return u.get();
        } else {
            return null;
        }
    }

    /**
     * Create - Add a new user
     * @param user An object user
     * @return The user object saved
     */
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return authService.saveUser(user);
    }




    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") final String email, @RequestBody User user) {
        Optional<User> u = authService.getUser(email);
        if(u.isPresent()) {

            User currentUser = u.get();

            String nickName = user.getNickname();
            if(nickName != null) {
                currentUser.setNickname(nickName);
            }

            String picture = user.getPicture();
            if(picture != null) {
                currentUser.setPicture(picture);
            }
            authService.saveUser(currentUser);
            return currentUser;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") final String id) {
        authService.deleteUser(id);
    }


}
