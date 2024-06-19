package com.example.banquemisr.challenge05.repository;


import com.example.banquemisr.challenge05.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    List<Task> findAllByDeadlineBetween(LocalDateTime start, LocalDateTime end);

}