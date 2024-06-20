package com.example.JJShop.model.enums;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    NAME_NOT_FOUND("Name don't found!"),
    NAME_EXISTS("The name is already registered!"),
    CATEGORY_EXISTS("The category is already created!!"),
    NAME_NOT_EXISTS("item list is empty"),
    CATEGORY_NOT_FOUND("The category is don't found!!"),
    USER_NOT_FOUND("User not found!"),
    USER_EMAIL_EXISTS("The email is already registered"),
    CREDENTIAL_INVALID("The credentials is invalid");

    private final String message;

    ErrorMessages(String message){
        this.message=message;
    }
}
