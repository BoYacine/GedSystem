package com.yacine.GedSystem.UserManagement.Repository;

import com.yacine.GedSystem.UserManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
