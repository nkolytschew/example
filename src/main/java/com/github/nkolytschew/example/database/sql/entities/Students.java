package com.github.nkolytschew.example.database.sql.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {

    @Id
    private Long id;
    private String name;
    private String lecture;
    private String address;

    public Students() {
    }

    public Students(Long id, String name, String lecture, String address) {
        this.id = id;
        this.name = name;
        this.lecture = lecture;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
