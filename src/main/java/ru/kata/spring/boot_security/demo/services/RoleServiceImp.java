package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    final
    RoleRepository repository;
    @Autowired
    public RoleServiceImp(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> roles() {
        return repository.findAll();
    }

    @Override
    public Role role(String name) {
        return repository.findRoleByName(name);
    }

}
