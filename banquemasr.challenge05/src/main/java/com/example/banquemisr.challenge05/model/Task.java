package com.example.banquemisr.challenge05.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime deadline;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}