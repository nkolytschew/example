package com.github.nkolytschew.example.database.nosql;

import com.github.nkolytschew.example.database.sql.entities.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomMongoRepository extends MongoRepository<Students, Long> {
}
