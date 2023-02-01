package com.yacine.GedSystem.FolderManagement.Entity;

import com.yacine.GedSystem.FileManagement.Entity.Document;
import com.yacine.GedSystem.Shared.SharedEntity;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
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
    private UserInfo userInfo;
    @OneToMany(mappedBy = "folder")
    private List<Document>documents;

}
