package com.vinch36.frontendjava.service;


import com.vinch36.frontendjava.model.User;
import com.vinch36.frontendjava.repository.UserProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    @Autowired
    private UserProxy userProxy;

    public User getEmployee(final int id) {
        return userProxy.getUser(id);
    }

    public Iterable<User> getUsers() {
        return userProxy.getUsers();
    }

    public void deleteUser(final int id) {
        userProxy.deleteUser(id);;
    }

    public User saveUser(User user) {
        User savedUser;

        // Règle de gestion : nom en majuscule
        user.setName(user.getName().toUpperCase());

        if(user.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedUser = userProxy.createUser(user);
        } else {
            savedUser = userProxy.updateUser(user);
        }

        return savedUser;
    }
}
