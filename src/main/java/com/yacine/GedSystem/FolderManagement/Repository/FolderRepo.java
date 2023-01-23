package com.yacine.GedSystem.FolderManagement.Repository;

import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepo extends JpaRepository<Folder,Integer> {
}
