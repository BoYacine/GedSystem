package com.yacine.GedSystem.UserManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestWithId {
    private int id;
    @NotBlank(message = "user name required")
    private String username;
    @NotBlank(message = "password required")
    @Size(min = 5,message = "password must be at least 5 character long")
    private String password;
    @NotBlank(message = "roles required")
    private String roles;
    @NotBlank(message = "path required")
    private String dependency;
}
