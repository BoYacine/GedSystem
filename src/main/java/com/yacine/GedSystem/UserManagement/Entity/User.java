package com.yacine.GedSystem.UserManagement.Entity;

import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.Shared.SharedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends SharedEntity<Integer> {

    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Folder> folders;

}
