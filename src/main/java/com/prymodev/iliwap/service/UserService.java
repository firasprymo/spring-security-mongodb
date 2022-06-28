package com.prymodev.iliwap.service;


import com.prymodev.iliwap.entity.*;
import com.prymodev.iliwap.DTO.UserDTO;

import java.util.*;

public interface UserService {

    public AppUser saveUser(UserDTO userDTO);

    public void addRoleToUser(String username, String role);

    public AppUser loadUserByUsername(String username);

    public List<AppUser> getAllUsers();


    public AppRole saveRole(AppRole role);

}
