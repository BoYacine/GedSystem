package com.yacine.GedSystem.UserManagement.mapper;

import com.yacine.GedSystem.Shared.SharedMapper;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.dto.UserRequestWithId;
import com.yacine.GedSystem.UserManagement.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper2 extends SharedMapper<UserInfo, UserRequestWithId, UserResponse> {
}
