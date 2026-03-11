package com.CRUD.exception;

public class DuplicateEmailFound extends RuntimeException {
    DuplicateEmailFound(){}
    public DuplicateEmailFound(String msg){
        super(msg);
    }
}
