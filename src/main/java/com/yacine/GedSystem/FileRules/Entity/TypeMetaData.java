package com.yacine.GedSystem.FileRules.Entity;

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
public class TypeMetaData extends SharedEntity<Integer> {
    @ManyToOne
    private Type type;
    @ManyToOne
    private MetaData metaData;
    @OneToMany(mappedBy = "typeMetaData")
    private List<MetaDataValue>metaDataValues;
}
