package com.yacine.GedSystem.FolderManagement.Repository;

import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepo extends JpaRepository<Folder,Integer> {

    Folder findByPath(String name);
    List<Folder> findByPointer(int pointer);

}
