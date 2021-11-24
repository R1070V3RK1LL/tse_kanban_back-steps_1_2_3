package org.rygn.kanban.controllers;

import org.rygn.kanban.dao.DeveloperRepository;
import org.rygn.kanban.domain.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("developers-rest")
public class DeveloperController {

     @GetMapping(path= "/{id}", produces = "application/json")
     public Optional<Developer> getDeveloper(@PathVariable long id){
          return findDeveloperById(id);
     }
     @Autowired
     private DeveloperRepository developerRepository;

     private Optional<Developer> findDeveloperById(long id) {
          return developerRepository.findById(id);
     }
     @GetMapping(path= "/developers", produces = "application/json")
     public List<Developer> getDevelopers(){
          return findAllDevelopers();
     }
     public List<Developer> findAllDevelopers() {

          return this.developerRepository.findAll();
     }
}
