package com.yacine.GedSystem.UserManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.Shared.SharedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends SharedEntity<Integer> {


    private String username;
    private String password;
    private String roles;
    private String dependency;
    @OneToMany(mappedBy = "userInfo")
    @JsonIgnore
    private List<Folder> folders;

}
