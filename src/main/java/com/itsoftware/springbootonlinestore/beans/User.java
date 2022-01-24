package com.itsoftware.springbootonlinestore.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity()
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String password, String firstName, String lastName, Role role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
