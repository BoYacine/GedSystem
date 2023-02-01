package com.yacine.GedSystem.UserManagement.Service;

import com.yacine.GedSystem.Exceptions.NotFoundException;
import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.FolderManagement.Repository.FolderRepo;
import com.yacine.GedSystem.FolderManagement.Service.FolderService;
import com.yacine.GedSystem.Security.UserInfoDetailService;
import com.yacine.GedSystem.Security.jwtService;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.Repository.UserRepo;
import com.yacine.GedSystem.UserManagement.dto.AuthRequest;
import com.yacine.GedSystem.UserManagement.dto.UserRequest;
import com.yacine.GedSystem.UserManagement.dto.UserResponse;
import com.yacine.GedSystem.UserManagement.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Builder
public class UserServiceImpl extends UserService {

    UserRepo userRepo;
    FolderService folderService;
    FolderRepo folderRepo;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;
    AuthenticationManager authenticationManager;
    UserInfoDetailService userInfoDetailService;
    jwtService jwtService;

    @Override
    public UserResponse addUser(UserRequest user) {
        //get folder parent
        Folder parent = folderRepo.findByPath(user.getDependency());
        //save user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDependency(user.getDependency() + "/" + user.getUsername());
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new NotFoundException("username already exist");
        }
        UserInfo userInfo = userMapper.dtoToEntity(user);
        userRepo.save(userInfo);
        //save folder
        Folder folder = Folder.builder()
                .name(user.getUsername())
                .path(userInfo.getDependency())
                .userInfo(userInfo)
                .pointer(parent.getId())
                .build();
        folderRepo.save(folder);
        //return response
        UserResponse response = userMapper.entityToDto(userInfo);
        return response;
    }

    @Override
    public String signIn(AuthRequest user) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        UserDetails userDetails = userInfoDetailService.loadUserByUsername(user.getUsername());
        String token = jwtService.generateToken(userDetails);
        return token;
    }

    @Override
    public UserResponse updateUser(UserRequest user, int id) {
        //user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo = userRepo.save(userMapper.dtoToEntity(user));
        UserResponse response = userMapper.entityToDto(userInfo);
        return response;
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserResponse getUserById(int id) {
        UserResponse response = userMapper.entityToDto(userRepo.findById(id).get());
        return response;
    }

    @Override
    public UserResponse getUserByName(String name) {
        UserResponse response = userMapper.entityToDto(userRepo.findByUsername(name));
        return response;
    }

    @Override
    public List<UserResponse> getListUserByName(String name) {
        List<UserResponse> responses = userMapper.entityToDto(userRepo.findByUsernameContains(name));
        return responses;
    }
}
