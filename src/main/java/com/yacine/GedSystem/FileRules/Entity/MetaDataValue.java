package com.yacine.GedSystem.FileRules.Entity;

import com.yacine.GedSystem.FileManagement.Entity.Document;
import com.yacine.GedSystem.Shared.SharedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
