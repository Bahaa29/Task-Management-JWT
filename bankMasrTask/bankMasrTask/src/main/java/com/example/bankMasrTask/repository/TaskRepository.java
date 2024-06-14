package com.example.bankMasrTask.repository;


import com.example.bankMasrTask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByDeadlineBetween(LocalDateTime start, LocalDateTime end);
    Task findByTitle(String title);
}