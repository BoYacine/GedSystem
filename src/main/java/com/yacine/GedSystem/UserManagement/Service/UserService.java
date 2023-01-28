package com.yacine.GedSystem.UserManagement.Service;

import com.yacine.GedSystem.Shared.SharedService;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.dto.UserRequest;
import com.yacine.GedSystem.UserManagement.dto.UserResponse;

import java.util.List;

public abstract class UserService extends SharedService<UserInfo,Integer> {
    public abstract UserResponse addUser(UserRequest user);
    public abstract String signIn(UserRequest user);
    public abstract UserResponse updateUser(UserRequest user, int id);
    public abstract void deleteUser(int id);
    public abstract UserResponse getUserById(int id);
    public abstract UserResponse getUserByName(String name);
    public abstract List<UserResponse> getListUserByName(String name);

}
