package com.prymodev.iliwap.resource;

import com.prymodev.iliwap.DTO.UserDTO;
import com.prymodev.iliwap.entity.AppUser;
import com.prymodev.iliwap.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
@RestController
public class UsersResource {

    private final UserService userService;
//
//
    @PostMapping("/signup")
    public ResponseEntity<AppUser> signUp(@RequestBody UserDTO userDTO) {

        return ResponseEntity.ok().body(userService.saveUser(userDTO));
    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<UserApp>> getUsersPage() {
//        log.debug("Getting users page");
//        return ResponseEntity.ok(userService.getAllUsers());
//    }


}
