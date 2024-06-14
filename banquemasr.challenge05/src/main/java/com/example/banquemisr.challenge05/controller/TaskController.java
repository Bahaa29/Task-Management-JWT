package com.example.bankMasrTask.controller;


import com.example.bankMasrTask.model.Task;
import com.example.bankMasrTask.repository.TaskRepository;
import com.example.bankMasrTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.bankMasrTask.specification.TaskSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    private final TaskRepository taskRepository;
    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate) {

        Specification<Task> spec = Specification.where(null);

        if (title != null) {
            spec = spec.and(TaskSpecification.hasTitle(title));
        }
        if (description != null) {
            spec = spec.and(TaskSpecification.hasDescription(description));
        }
        if (status != null) {
            spec = spec.and(TaskSpecification.hasStatus(status));
        }
        if (startDate != null && endDate != null) {
            spec = spec.and(TaskSpecification.dueDateBetween(startDate, endDate));
        }

        List<Task> tasks = taskRepository.findAll(spec);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return ResponseEntity.ok(taskService.updateTask(id, taskDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
}
