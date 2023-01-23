package com.yacine.GedSystem.FileRules.Entity;

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
public class MetaData extends SharedEntity<Integer> {
    private String name;
    private String typeData;
    @OneToMany(mappedBy = "metaData")
    private List<TypeMetaData> typeMetaData;
}
