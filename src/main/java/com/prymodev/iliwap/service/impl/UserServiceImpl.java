package com.prymodev.iliwap.service.impl;

import com.prymodev.iliwap.DTO.UserDTO;
import com.prymodev.iliwap.entity.AppRole;
import com.prymodev.iliwap.entity.AppUser;
import com.prymodev.iliwap.repository.RoleRepository;
import com.prymodev.iliwap.repository.UserRepository;
import com.prymodev.iliwap.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public List<AppUser> getAllUsers() {
        log.debug("Getting all users");
        return userRepository.findAll(Sort.by("email"));
    }

    @Override
    public AppUser saveUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        AppUser user = userRepository.findByEmail(username);
        if (user != null) {
            throw new RuntimeException("This is already exists, Try with an other username");
        }
        String password = userDTO.getPassword();
        String repassword = userDTO.getPasswordRepeated();
        if (!password.equals(repassword)) {
            throw new RuntimeException("You must confirm your password");
        }
        AppUser appUser = new AppUser();
        appUser.setUsername(userDTO.getUsername());
        appUser.setEmail(userDTO.getEmail());
        appUser.setActived(true);
        appUser.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userRepository.save(appUser);
        addRoleToUser(username, "USER");
        return appUser;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepository.findByEmail(username);
        AppRole role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }
}
