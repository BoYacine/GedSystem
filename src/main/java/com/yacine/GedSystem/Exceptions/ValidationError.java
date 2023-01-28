package com.yacine.GedSystem.Exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class ValidationError {
    private List<String> errors;
    private String uri;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    public ValidationError(){
        this.timestamp=new Date();
        this.errors=new ArrayList<>();
    }
    public void addError(String error){
        this.errors.add(error);
    }
}
