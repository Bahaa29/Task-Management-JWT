package com.example.banquemisr.challenge05.specification;

import com.example.banquemisr.challenge05.model.Task;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class TaskSpecification {

    public static Specification<Task> hasTitle(String title) {
        return (task, cq, cb) -> cb.like(task.get("title"), "%" + title + "%");
    }

    public static Specification<Task> hasDescription(String description) {
        return (task, cq, cb) -> cb.like(task.get("description"), "%" + description + "%");
    }

    public static Specification<Task> hasStatus(String status) {
        return (task, cq, cb) -> cb.equal(task.get("status"), status);
    }

    public static Specification<Task> dueDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return (task, cq, cb) -> cb.between(task.get("deadline"), startDate, endDate);
    }
}
