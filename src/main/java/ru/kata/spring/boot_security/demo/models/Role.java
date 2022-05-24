package ru.kata.spring.boot_security.demo.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    public Role(){

    }
    public Role(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @Transient
    public String getNameWithoutROLE() {
        return name.substring(5);
    }
}
