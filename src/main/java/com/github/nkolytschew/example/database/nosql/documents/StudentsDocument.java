package com.github.nkolytschew.example.database.nosql.documents;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class StudentsDocument {

    @Id
    private Long id;
    private String name;
    private String lecture;
    private String address;

    public StudentsDocument() {
    }

    public StudentsDocument(Long id, String name, String lecture, String address) {
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
