package com.example.JJShop.model.enums;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    NAME_NOT_FOUND("Name don't found!"),
    NAME_EXISTS("The name is already registered!"),
    CATEGORY_EXISTS("The category is already created!!"),
    CATEGORY_NOT_FOUND("The category is don't found!!");

    private final String message;

    ErrorMessages(String message){
        this.message=message;
    }
}
