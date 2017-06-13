package com.citaprevia.dariomartin.citaprevia.model;

/**
 * Created by dariomartin on 13/6/17.
 */

public class User {

    enum Role{
        PATIENT, PROFESSIONAL
    }

    private Role role;
    private String name;
    private String surname;
    private String age;

    public User(Role role, String name, String surname) {
        this.role = role;
        this.name = name;
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
