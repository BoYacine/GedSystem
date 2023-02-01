package com.yacine.GedSystem.FolderManagement.dto;

import com.yacine.GedSystem.UserManagement.dto.UserRequest;
import com.yacine.GedSystem.UserManagement.dto.UserResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

@Setter
@Getter
public class FolderResponse {
    private int id;
    private String name;
    private int pointer;
    private String path;
    private UserResponse userInfo;
}
