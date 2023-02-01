package com.yacine.GedSystem.FolderManagement.Service;

import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.FolderManagement.dto.FolderRequest;
import com.yacine.GedSystem.FolderManagement.dto.FolderResponse;
import com.yacine.GedSystem.Shared.SharedService;

import java.util.List;

public abstract class FolderService extends SharedService {

    public final String ROOT = "/root";
    public final String HOME = ROOT + "/home";
    public final String ORGANIZATION = HOME + "/organization";

    public abstract FolderResponse saveFolderToUser(FolderRequest folder);

    public abstract List<FolderResponse> findAll();

    public abstract List<FolderResponse> getNodesOfFolder(int id);

}
