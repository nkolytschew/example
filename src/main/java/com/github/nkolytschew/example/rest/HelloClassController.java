package com.github.nkolytschew.example.rest;


import com.github.nkolytschew.example.database.sql.StudentsRepository;
import com.github.nkolytschew.example.database.sql.entities.Students;
import com.github.nkolytschew.example.rest.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
public class HelloClassController {

    private final StudentsRepository repository;

    /**
     * Please keep in mind, that H2 will be cleared on every restart of you application, therefore we populate Students Table with some arbitrary entries.
     * If you are going to use a non In-Memory Database, you probably should remove the population.
     * <p>
     * Also, using construction injection for Repository
     *
     * @param repository {@link StudentsRepository}
     */
    @Autowired
    public HelloClassController(StudentsRepository repository) {
        this.repository = repository;

        // generate some Students on Startup
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(i -> {
                    Students s = new Students(new Random().nextLong(), "klaus" + UUID.randomUUID().toString(), "distributed system", "somewhere over the rainbow");
                    this.repository.save(s);
                });
    }

    /**
     * Prints simple HelloMessage as JSON to the Browser.
     *
     * @return HelloMessage {@link HelloMessage}
     */
    @GetMapping("hello")
    public HelloMessage getMessage() {
        return new HelloMessage("hello class");
    }

    /**
     * Submit {@link HelloMessage} from Browser to our application and prints it on the browser again.
     * Use CURL or Postman for POST, PUT, DELETE
     *
     * @param message {@link HelloMessage}
     * @return {@link HelloMessage}
     */
    @PostMapping("submit")
    public HelloMessage submitMessage(@RequestBody HelloMessage message) {
        return message;
    }

    // CRUD operation for StudentsRepository

    /**
     * Get all {@link Students}
     *
     * @return {@link List} of {@link Students}
     */
    @GetMapping("students")
    public List<Students> getStudents() {
        return (List<Students>) this.repository.findAll();
    }

    /**
     * Get one {@link Students} via its Id.
     *
     * @param id {@link Long}
     * @return {@link Students}
     */
    @GetMapping("student/{id}")
    public Students getStudent(@PathVariable Long id) {
        return this.repository.findById(id).get();
    }

    /**
     * Get one {@link Students} via its name.
     *
     * @param name {@link String}
     * @return {@link Students}
     */
    @GetMapping("student/{name}")
    public List<Students> getStudentsByName(@PathVariable String name) {
        return repository.findAllByName(name);
    }
}


