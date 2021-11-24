package org.rygn.kanban.controllers;


import org.rygn.kanban.dao.TaskRepository;
import org.rygn.kanban.domain.Task;
import org.rygn.kanban.domain.TaskStatus;
import org.rygn.kanban.service.TaskService;
import org.rygn.kanban.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks-rest")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(path= "/{id}", produces = "application/json")
    public Task getTask(@PathVariable long id){
        return this.taskService.findTask(id);
    }

    @GetMapping(path= "/tasks", produces = "application/json")
    public Collection<Task> getTasks(){
        return this.taskService.findAllTasks();
    }

    
    @PostMapping(path= "/tasks", consumes="application/json", produces= "application/json")
    public Task createTask(Task task){
        return this.taskService.createTask(task);
    }

    @PatchMapping(path="tasks/{id}", consumes="application/json", produces="application/json")
    public Task moveTask(Task task){
        return this.taskService.moveRightTask(task);
    }

}