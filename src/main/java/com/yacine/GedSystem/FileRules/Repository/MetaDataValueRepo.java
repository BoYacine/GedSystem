package com.yacine.GedSystem.FileRules.Repository;

import com.yacine.GedSystem.FileRules.Entity.MetaDataValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaDataValueRepo extends JpaRepository<MetaDataValue,Integer> {
}
