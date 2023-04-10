package com.yacine.GedSystem.UserManagement.Controller;




import com.yacine.GedSystem.UserManagement.Service.UserService;
import com.yacine.GedSystem.UserManagement.Service.UserServiceImpl;
import com.yacine.GedSystem.UserManagement.dto.AuthRequest;
import com.yacine.GedSystem.UserManagement.dto.UserRequest;
import com.yacine.GedSystem.UserManagement.dto.UserResponse;
import com.yacine.GedSystem.UserManagement.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/add")
    public UserResponse addUser(@Validated @RequestBody UserRequest request) {
        return userServiceImpl.addUser(request);
    }
    @PostMapping("/auth")
    public String signIn(@Validated @RequestBody AuthRequest request) {
        return userServiceImpl.signIn(request);
    }
    @PatchMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ROOT')")
    public ResponseEntity<UserResponse> updateUser(@Validated @RequestBody UserRequest request,@PathVariable int id){
        return ResponseEntity.ok(userServiceImpl.updateUser(request,id));
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ROOT')")
    public void deleteUser(@PathVariable int id){
        userServiceImpl.deleteUser(id);
    }
    @GetMapping("/byid/{id}")
    public UserResponse getUserById(@PathVariable int id){
        return userServiceImpl.getUserById(id);
    }
    @GetMapping("/byname/{name}")
    @PreAuthorize("hasAuthority('ROLE_ROOT')")
    public UserResponse getUserByName(@PathVariable String name){
        return userServiceImpl.getUserByName(name);
    }
    @GetMapping("/bynames/{name}")
    @PreAuthorize("hasAuthority('ROLE_ROOT')")
    public List<UserResponse> getListUserByName(@PathVariable String name){
        return userServiceImpl.getListUserByName(name);
    }
    @GetMapping("")
    @PreAuthorize("hasAuthority('ROLE_ROOT')")
//    @Parameters({
//            @Parameter(name = "Authorization", description = "jwt token",in = ParameterIn.HEADER)
//    })
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> responses = userMapper.entityToDto(userService.findAll());
        return ResponseEntity.ok(responses);
    }

}
