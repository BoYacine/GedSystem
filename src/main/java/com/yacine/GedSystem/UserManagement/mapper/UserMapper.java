package com.yacine.GedSystem.UserManagement.mapper;

import com.yacine.GedSystem.Shared.SharedMapper;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.dto.UserRequest;
import com.yacine.GedSystem.UserManagement.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends SharedMapper<UserInfo, UserRequest, UserResponse> {


}
