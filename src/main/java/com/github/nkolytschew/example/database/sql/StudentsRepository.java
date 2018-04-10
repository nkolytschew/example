package com.github.nkolytschew.example.database.sql;

import com.github.nkolytschew.example.database.sql.entities.Students;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentsRepository extends CrudRepository<Students, Long> {

    public List<Students> findAllByName(String name);

}


