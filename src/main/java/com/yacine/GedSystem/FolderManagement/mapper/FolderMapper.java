package com.yacine.GedSystem.FolderManagement.mapper;

import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.FolderManagement.dto.FolderRequest;
import com.yacine.GedSystem.FolderManagement.dto.FolderResponse;
import com.yacine.GedSystem.Shared.SharedMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FolderMapper extends SharedMapper<Folder, FolderRequest, FolderResponse> {
}
