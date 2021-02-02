package com.phenologixscrum.api.controller;

import com.phenologixscrum.api.User;
import com.phenologixscrum.api.exception.ResourceNotFoundException;
import com.phenologixscrum.api.repository.UserRepository;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User createUser(@Validated @RequestBody User user) {
            return  userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }


    @PostMapping("/user/login/{user_email}/{user_password}")
    public User login(@PathVariable(value = "user_email") String userEmail,@PathVariable(value = "user_password") String userPassword  ) {
        System.out.println(userEmail + userPassword);
        for (User user: userRepository.findAll()) {
            if (user.getUser_email().equals(userEmail) && user.getUser_password().equals(userPassword)) {

                return user;
            }
        }

        throw new ResourceNotFoundException("User", "email", userEmail);
    }

//    private String getJWTToken(String username) {
//        String secretKey = "mySecretKey";
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList("ROLE_USER");
//
//        String token = Jwt
//                .builder()
//                .setId("softtekJWT")
//                .setSubject(username)
//                .claim("authorities",
//                        grantedAuthorities.stream()
//                                .map(GrantedAuthority::getAuthority)
//                                .collect(Collectors.toList()))
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 600000))
//                .signWith(SignatureAlgorithm.registerDefaultAlgorithms(),
//                        secretKey.getBytes()).compact();
//
//        return "Bearer " + token;
//    }



//
//    @PutMapping("/user/{id}")
//    public User updateNote(@PathVariable(value = "id") Long userId,
//                           @Validated @RequestBody User userDetails) {
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//
//        user.setUser_firstname(userDetails.getUser_firstname());
//        user.setUser_lastname(userDetails.getUser_lastname());
//        user.setUser_email(userDetails.getUser_email());
//        user.setUser_password(userDetails.getUser_password());
//        user.setUser_dateofbirth(userDetails.getUser_dateofbirth());
//        user.setUser_expirationlink(userDetails.getUser_expirationlink());
//        user.setUser_isenable(userDetails.getUser_isenable());
//
//        User updatedUser = userRepository.save(user);
//        return updatedUser;
//    }
//
//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//
//        userRepository.delete(user);
//
//        return ResponseEntity.ok().build();
//    }




}
