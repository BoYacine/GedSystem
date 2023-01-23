package com.yacine.GedSystem.FolderManagement.Entity;

import com.yacine.GedSystem.FileManagement.Entity.Document;
import com.yacine.GedSystem.Shared.SharedEntity;
import com.yacine.GedSystem.UserManagement.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Folder extends SharedEntity<Integer> {

    private String name;
    private int pointer;
    private String path;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "folder")
    private List<Document>documents;

}
