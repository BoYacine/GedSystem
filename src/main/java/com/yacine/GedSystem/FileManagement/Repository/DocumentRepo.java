package com.yacine.GedSystem.FileManagement.Repository;

import com.yacine.GedSystem.FileManagement.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.traversal.DocumentTraversal;

public interface DocumentRepo extends JpaRepository<Document,Integer> {
}
