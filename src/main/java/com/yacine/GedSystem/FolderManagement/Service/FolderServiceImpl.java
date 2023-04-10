package com.yacine.GedSystem.FolderManagement.Service;

import com.yacine.GedSystem.Exceptions.NotFoundException;
import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.FolderManagement.Repository.FolderRepo;
import com.yacine.GedSystem.FolderManagement.dto.FolderRequest;
import com.yacine.GedSystem.FolderManagement.dto.FolderResponse;
import com.yacine.GedSystem.FolderManagement.dto.FolderTree;
import com.yacine.GedSystem.FolderManagement.mapper.FolderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class FolderServiceImpl extends FolderService {
    @Autowired
    private FolderRepo folderRepo;
    @Autowired
    private FolderMapper mapper;

    @Override
    public FolderResponse saveFolderToUser(FolderRequest request) {
        Folder folder = mapper.dtoToEntity(request);
        log.info("" + folder);
        folder.setPath(folderRepo.findById(request.getPointer()).get().getPath() + "/" + request.getName());
        folderRepo.save(folder);
        FolderResponse response = mapper.entityToDto(folder);
        return response;
    }

    @Override
    public List<FolderResponse> findAll() {
        List<FolderResponse> responses = mapper.entityToDto(folderRepo.findAll());
        return responses;
    }

    public List<FolderResponse> getNodesOfFolder(int id) {
        List<Folder> folders = folderRepo.findByPointer(id);
        List<FolderResponse> responses = mapper.entityToDto(folders);
        return responses;
    }

    @Override
    public FolderTree getFolderTree(int folderId) {
        Folder folder=folderRepo.findById(folderId).orElseThrow(() -> new NotFoundException("not found"));
        List<FolderResponse> folderTree= getChildren(folder);
        return new FolderTree(folderTree);
    }

    @Override
    public List<FolderResponse> getChildren(Folder folder) {
        List<Folder> childFolders= folderRepo.findByPointer(folder.getId());
        List<FolderResponse> responses=new ArrayList<>();
           FolderResponse response=mapper.entityToDto(folder);
           responses.add(response);
        childFolders.forEach(f -> responses.addAll(getChildren(f)));
        return responses;
    }

}
