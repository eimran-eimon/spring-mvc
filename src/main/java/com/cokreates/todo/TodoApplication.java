package com.cokreates.todo;

import com.cokreates.todo.model.Developer;
import com.cokreates.todo.model.Skill;
import com.cokreates.todo.repository.DeveloperRepository;
import com.cokreates.todo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    SkillRepository skillRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Skill javascript = new Skill("javascript", "Javascript language skill");
        Skill ruby = new Skill("ruby", "Ruby language skill");
        Skill emberjs = new Skill("emberjs", "Emberjs framework");
        Skill angularjs = new Skill("angularjs", "Angularjs framework");

        skillRepository.save(javascript);
        skillRepository.save(ruby);
        skillRepository.save(emberjs);
        skillRepository.save(angularjs);
        List<Developer> developerList = new LinkedList<Developer>();
        developerList.add(new Developer("Eimran", "Eimon", "eimran@cokreates.com",
                Arrays.asList(new Skill[]{javascript, ruby})));
        developerList.add(new Developer("E", "Eimran", "eimon@cokreates.com",
                Arrays.asList(new Skill[]{emberjs, angularjs})));
        developerRepository.saveAll(developerList);
    }
}
