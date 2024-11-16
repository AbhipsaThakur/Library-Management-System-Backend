package com.example.springsecurity.test.librarymanagementsystembackend;

public class ResourceNotFountException extends RuntimeException {
    private String resourceName;
    private String fildName;
    private Object objectvalue;
    public ResourceNotFountException(String resourceName, String fildName, Object objectvalue) {
        super(String.format("%s Id Does Not Exist %s: %s", resourceName, fildName, objectvalue));
        this.resourceName = resourceName;
        this.fildName = fildName;
        this.objectvalue = objectvalue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFildName() {
        return fildName;
    }

    public Object getObjectvalue() {
        return objectvalue;
    }
}
