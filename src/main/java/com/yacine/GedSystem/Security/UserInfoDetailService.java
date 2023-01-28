package com.yacine.GedSystem.Security;



import com.yacine.GedSystem.Exceptions.NotFoundException;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserInfoDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=userRepo.findByUsername(username);
        if (userInfo == null){
            throw new NotFoundException("user not found");
        }
        UserInfoDetails userInfoDetails = new UserInfoDetails(userInfo);
        return  userInfoDetails;
    }
}
