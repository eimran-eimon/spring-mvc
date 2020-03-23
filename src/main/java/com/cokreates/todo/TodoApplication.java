package com.cokreates.todo;

import com.cokreates.todo.model.Developer;
import com.cokreates.todo.model.Skill;
import com.cokreates.todo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{

    @Autowired
    DeveloperRepository developerRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List<Developer> developerList = new LinkedList<Developer>();
//        developerList.add(new Developer("Eimran", "Eimon", "eimran@cokreates.com"));
//        developerList.add(new Developer("E", "Eimran", "eimon@cokreates.com"));
        developerRepository.saveAll(developerList);
    }
}
