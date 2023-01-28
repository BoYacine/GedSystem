package com.yacine.GedSystem.FileRules.Entity;

import com.yacine.GedSystem.FileManagement.Entity.Document;
import com.yacine.GedSystem.Shared.SharedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaDataValue extends SharedEntity<Integer> {

    private String value;
    @ManyToOne
    private TypeMetaData typeMetaData;
    @ManyToOne
    private Document document;

}
