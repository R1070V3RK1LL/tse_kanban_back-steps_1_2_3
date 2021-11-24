package org.rygn.kanban.controllers;

import org.rygn.kanban.dao.DeveloperRepository;
import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.service.DeveloperService;
import org.rygn.kanban.service.impl.DeveloperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/developers-rest")
public class DeveloperController {

     @Autowired
     private DeveloperService developerService;
     private DeveloperRepository developerRepository;

     @GetMapping(path= "/{id}", produces = "application/json")
     public Optional<Developer> getDeveloper(@PathVariable long id){
          return findDeveloperById(id);
     }

     private Optional<Developer> findDeveloperById(long id) {
          return this.developerRepository.findById(id);
     }
     @GetMapping(path= "/developers", produces = "application/json")
     public List<Developer> getDevelopers(){
          return this.developerService.findAllDevelopers();
     }

     @PostMapping(path= "/developers", consumes="application/json", produces= "application/json")
     public Developer createDeveloper(Developer developer){
          return this.developerRepository.save(developer);
     }

}
