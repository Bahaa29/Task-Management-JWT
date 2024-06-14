package com.example.bankMasrTask.repository;


import com.example.bankMasrTask.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
