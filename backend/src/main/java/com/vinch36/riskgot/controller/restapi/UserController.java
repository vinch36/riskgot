package com.vinch36.riskgot.controller.restapi;

import com.vinch36.riskgot.model.User;
import com.vinch36.riskgot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * Read - Get all users
     * @return - An Iterable object of User
     */
    @GetMapping("/user")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/user/{id}")
    public User getEmployee(@PathVariable("id") final Long id) {
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    /**
     * Create - Add a new user
     * @param user An object user
     * @return The user object saved
     */
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }




    @PutMapping("/user/{id}")
    public User updateEmployee(@PathVariable("id") final Long id, @RequestBody User user) {
        Optional<User> u = userService.getUser(id);
        if(u.isPresent()) {
            User currentUser = u.get();

            String name = user.getName();
            if(name != null) {
                currentUser.setName(name);
            }
            String mail = user.getEmail();
            if(mail != null) {
                currentUser.setEmail(mail);
            }
            String password = user.getPassword();
            if(password != null) {
                currentUser.setPassword(password);;
            }
            userService.saveUser(currentUser);
            return currentUser;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") final Long id) {
        userService.deleteUser(id);
    }


}
