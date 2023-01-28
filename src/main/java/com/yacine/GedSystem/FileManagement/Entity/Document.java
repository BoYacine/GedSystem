package com.yacine.GedSystem.FileManagement.Entity;

import com.yacine.GedSystem.FileRules.Entity.MetaDataValue;
import com.yacine.GedSystem.FileRules.Entity.Type;
import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.Shared.SharedEntity;
import jakarta.persistence.Entity;
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
public class Document extends SharedEntity<Integer> {

    private String name;
    @ManyToOne
    private Folder folder;
    @ManyToOne
    private Type type;
    @OneToMany(mappedBy = "document")
    private List<MetaDataValue> metaDataValues;

}
