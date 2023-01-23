package com.yacine.GedSystem.FileRules.Entity;

import com.yacine.GedSystem.Shared.SharedEntity;
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
public class TypeMetaData extends SharedEntity<Integer> {
    @ManyToOne
    private Type type;
    @ManyToOne
    private MetaData metaData;
    @OneToMany(mappedBy = "typeMetaData")
    private List<MetaDataValue>metaDataValues;
}
