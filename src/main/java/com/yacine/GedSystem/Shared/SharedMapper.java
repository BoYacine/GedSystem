package com.yacine.GedSystem.Shared;

import org.aspectj.weaver.patterns.DeclareTypeErrorOrWarning;

import java.util.List;

public interface SharedMapper<T,RQ_DTO,RS_DTO>{

    RS_DTO entityToDto(T entity);
    T dtoToEntity(RQ_DTO dto);
    List<RS_DTO> entityToDto(List<T> entities);
    List<T> dtoToEntity(List<RQ_DTO> dots);
}
