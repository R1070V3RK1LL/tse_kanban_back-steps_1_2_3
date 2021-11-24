package org.rygn.kanban.controllers;


import org.rygn.kanban.dao.TaskRepository;
import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks-rest")
public class TaskController {

    @GetMapping(path= "/{id}", produces = "application/json")
    public Optional<Task> getTask(@PathVariable long id){
        return findTaskById(id);
    }
    @Autowired
    private TaskRepository taskRepository;

    private Optional<Task> findTaskById(long id) {
        return taskRepository.findById(id);
    }

    @GetMapping(path= "/tasks", produces = "application/json")
    public List<Task> getTasks(){
        return findAllTasks();
    }
    public List<Task> findAllTasks() {

        return this.taskRepository.findAll();
    }
}