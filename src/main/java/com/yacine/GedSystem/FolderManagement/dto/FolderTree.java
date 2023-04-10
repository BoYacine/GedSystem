package com.yacine.GedSystem.FolderManagement.dto;

import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FolderTree {


    private List<FolderResponse> children;

    public FolderTree(List<FolderResponse> children) {
        this.children = children;
    }




}
