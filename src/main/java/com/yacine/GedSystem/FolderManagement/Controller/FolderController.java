package com.yacine.GedSystem.FolderManagement.Controller;


import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.FolderManagement.Service.FolderService;
import com.yacine.GedSystem.FolderManagement.dto.FolderRequest;
import com.yacine.GedSystem.FolderManagement.dto.FolderResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/folder/")
@AllArgsConstructor
public class FolderController {

    private FolderService folderService;

    @GetMapping("")
    public List<FolderResponse> findAll(){
        return folderService.findAll();
    }

    @PostMapping("add")
    public FolderResponse saveFolderToUser(@Validated @RequestBody FolderRequest request){
        return folderService.saveFolderToUser(request);
    }
    @GetMapping("nodes/{id}")
    public List<FolderResponse> getNodesOfFolder(@PathVariable int id){
        return folderService.getNodesOfFolder(id);
    }


}
