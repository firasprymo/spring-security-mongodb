package com.prymodev.iliwap.entity;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;


@Data
@Document(collection = "users")
public class AppUser {
    @Id
    private String id;
    private String username;
    @Indexed(unique = true)
    private String email;
    private String password;
    private boolean actived;
    private Collection<AppRole> roles = new ArrayList<>();



}
