package org.example.springtp.models;

import org.example.springtp.entities.User;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public enum ManageLogin {
    instance;

    private HashMap<String, User> users = new HashMap<>();

    public void addUser(String username, String email, String password) {
        users.put(email, new User(username, email, password));
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public boolean checkCredentials(String email, String password) {
        User user = users.get(email);
        return user != null && user.getPassword().equals(password);
    }

    public User getUserByEmail(String email) {
        return users.get(email);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
