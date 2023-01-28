package com.yacine.GedSystem.UserManagement.Controller;


import com.yacine.GedSystem.Exceptions.NotFoundException;
import com.yacine.GedSystem.Security.AuthRequest;
import com.yacine.GedSystem.Security.UserInfoDetailService;
import com.yacine.GedSystem.Security.jwtService;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.Repository.UserRepo;
import com.yacine.GedSystem.UserManagement.Service.UserService;
import com.yacine.GedSystem.UserManagement.Service.UserServiceImpl;
import com.yacine.GedSystem.UserManagement.dto.UserRequest;
import com.yacine.GedSystem.UserManagement.dto.UserResponse;
import com.yacine.GedSystem.UserManagement.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserServiceImpl userServiceImpl;
    private UserService userService;
    private UserMapper userMapper;
    UserInfoDetailService userInfoDetailService;
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private jwtService jwtService;
    private AuthenticationManager authenticationManager;


    @PostMapping("/add")
    public UserResponse addUser(@Validated @RequestBody UserRequest request) {
        return userServiceImpl.addUser(request);
    }

    @PostMapping("/auth")
    public String signIn(@Validated @RequestBody UserRequest request) {
        return userServiceImpl.signIn(request);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> responses = userMapper.entityToDto(userService.findAll());
        return ResponseEntity.ok(responses);
    }

}
