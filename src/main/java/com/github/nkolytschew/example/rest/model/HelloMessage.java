package com.github.nkolytschew.example.rest.model;

public class HelloMessage {
    private String message;

    public HelloMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}