package com.example.servletexample.runTimeRepository;

import com.example.servletexample.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum Users {
    INSTANCE;

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Optional<User> findUserByUsername(String username) {
        return users.stream()
                .filter(user -> username.equals(user.getUsername()) && !username.isEmpty())
                .findAny();
    }
}
