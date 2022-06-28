package com.prymodev.iliwap.DTO;

import com.prymodev.iliwap.entity.AppRole;
import lombok.Data;


@Data
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String passwordRepeated;
    private AppRole roles;


}
