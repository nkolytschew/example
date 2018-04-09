package com.github.nkolytschew.example.rest;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloClassController {

    @GetMapping("hello")
    public HelloMessage getMessage() {
        return new HelloMessage("hello class");
    }

}

class HelloMessage {
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
