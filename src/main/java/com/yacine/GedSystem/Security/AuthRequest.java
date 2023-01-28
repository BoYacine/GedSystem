package com.yacine.GedSystem.Security;



import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String username;
    @Size(min = 5,message = "password must be at least 5 character long")
    private String password;

}
