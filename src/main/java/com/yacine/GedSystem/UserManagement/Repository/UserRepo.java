package com.yacine.GedSystem.UserManagement.Repository;

import com.yacine.GedSystem.Shared.SharedRepository;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends SharedRepository<UserInfo,Integer> {

    UserInfo findByUsername(String name);
}
