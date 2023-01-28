package com.yacine.GedSystem.UserManagement.dto;


import com.yacine.GedSystem.Shared.SharedDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends SharedDto {
    private String username;
    private String roles;

}
