package com.yacine.GedSystem.FileRules.Entity;

import com.yacine.GedSystem.FileManagement.Entity.Document;
import com.yacine.GedSystem.Shared.SharedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Type extends SharedEntity<Integer> {

    private String name;
    @OneToMany(mappedBy = "type")
    private List<Document>documents;
    @OneToMany(mappedBy = "type")
    private List<TypeMetaData> typeMetaData;

}
