package com.hexagonal.demo.hexagonal_demo.infrastructure.controller;

import com.hexagonal.demo.hexagonal_demo.application.service.TaskService;
import com.hexagonal.demo.hexagonal_demo.domain.model.AdditionalTaskInfo;
import com.hexagonal.demo.hexagonal_demo.domain.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task creastedTask = taskService.createTask(task);
        return new ResponseEntity<>(creastedTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTask(id)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Task> getaAllTask() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity(tasks, HttpStatus.OK);
    }


    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long tasKId, @RequestBody Task updateTask) {
        return taskService.updateTask(tasKId, updateTask)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long taskId) {
        if (taskService.deleteTask(taskId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{taskId}/aditionalInfo")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable Long id) {
        AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(id);
        return new ResponseEntity<>(additionalTaskInfo, HttpStatus.OK);

    }


}
