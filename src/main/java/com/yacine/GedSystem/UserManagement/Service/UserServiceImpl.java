package com.yacine.GedSystem.UserManagement.Service;

import com.yacine.GedSystem.Exceptions.NotFoundException;
import com.yacine.GedSystem.Security.UserInfoDetailService;
import com.yacine.GedSystem.Security.jwtService;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.Repository.UserRepo;
import com.yacine.GedSystem.UserManagement.dto.UserRequest;
import com.yacine.GedSystem.UserManagement.dto.UserResponse;
import com.yacine.GedSystem.UserManagement.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl extends UserService {

    UserRepo userRepo;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;
    AuthenticationManager authenticationManager;
    UserInfoDetailService userInfoDetailService;
    jwtService jwtService;

    @Override
   public UserResponse addUser(UserRequest user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepo.findByUsername(user.getUsername())!=null){
            throw new NotFoundException("username already exist");
        }
        UserInfo userInfo=userMapper.dtoToEntity(user);
        userRepo.save(userInfo);
        UserResponse response=userMapper.entityToDto(userInfo);
        return response ;
    }

    @Override
    public String signIn(UserRequest user) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        UserDetails userDetails=userInfoDetailService.loadUserByUsername(user.getUsername());
        String token=jwtService.generateToken(userDetails);
        return token;
    }

    @Override
    public UserResponse updateUser(UserRequest user, int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public UserResponse getUserById(int id) {
        return null;
    }

    @Override
    public UserResponse getUserByName(String name) {
        return null;
    }

    @Override
    public List<UserResponse> getListUserByName(String name) {
        return null;
    }
}
