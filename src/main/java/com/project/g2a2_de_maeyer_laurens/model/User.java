package com.project.g2a2_de_maeyer_laurens.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "firstname")
    @NotBlank
    @Size(min=3, max=60)
    private String firstname;

    @Column(name = "lastname")
    @NotBlank
    @Size(min=3, max=60)
    private String lastname;

    @Column(name = "password")
    private String password;

    @Column (name = "salt")
    private String salt;

    @Column(name = "email")
    @NotBlank
    private String email;

    @Column(name = "role")
    private String role;

    @ManyToMany
    private List<Book> books;

    public User(String firstname, String lastname, String password, String salt, String email, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.role = role;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
