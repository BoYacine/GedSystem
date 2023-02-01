package com.yacine.GedSystem.FolderManagement.dto;


import com.yacine.GedSystem.UserManagement.dto.UserRequest;
import com.yacine.GedSystem.UserManagement.dto.UserRequestWithId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FolderRequest {


    private String name;
    private int pointer;
   // private String path;
    private UserRequestWithId userInfo;
}
