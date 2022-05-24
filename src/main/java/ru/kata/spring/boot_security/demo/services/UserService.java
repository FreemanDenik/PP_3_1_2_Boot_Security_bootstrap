package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> users();
    void create(User user);
    void edit(int id, User user);

    User findUserById(int id);
    User findUserByName(String name);
    void delete(int id);
    boolean userHaveRole(String username, String roleName);
}
