package com.yacine.GedSystem.FileRules.Repository;

import com.yacine.GedSystem.FileRules.Entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaDataRepo extends JpaRepository<MetaData,Integer> {
}
