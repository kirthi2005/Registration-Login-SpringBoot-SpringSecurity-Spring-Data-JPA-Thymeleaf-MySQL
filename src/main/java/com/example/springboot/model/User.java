package com.example.springboot.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

import java.util.Collection;
//To make this class as JPA Entity
@Entity
//provide table name and email is unique constraint in the user table
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    //@Id to make it as primary key
    @Id
    //providing Generated value Strategies
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="users_role",
            joinColumns=@JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
    )
    private Collection<Role> roles;

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
