package com.yacine.GedSystem.Shared;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@MappedSuperclass
public abstract class SharedService<T,ID>{

    @Autowired
    private SharedRepository<T,ID> sharedRepository;

    public List<T> findAll(){
        return sharedRepository.findAll();
    }

    public T findById(ID id){
        return sharedRepository.findById(id).get();
    }

    public T getOne(ID id){
        return sharedRepository.getById(id);
    }

    public T insert(T entity){
        return sharedRepository.save(entity);
    }

    public T Update(T entity){
        return sharedRepository.save(entity);
    }

    public void deleteById(ID id){
        sharedRepository.deleteById(id);
    }

    public void deleteAll(List<ID> ids ){
        ids.forEach(id -> sharedRepository.deleteById(id));
    }
}
