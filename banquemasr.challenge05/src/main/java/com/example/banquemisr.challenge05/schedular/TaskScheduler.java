package com.example.banquemisr.challenge05.schedular;


import com.example.bankMasrTask.service.EmailService;
import com.example.banquemisr.challenge05.model.Task;
import com.example.banquemisr.challenge05.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TaskScheduler {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 * * * *") // Runs every hour
    public void checkTaskDeadlines() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneDayLater = now.plusDays(1);

        List<Task> tasks = taskRepository.findAllByDeadlineBetween(now, oneDayLater);
        for (Task task : tasks) {
            String subject = "Upcoming Task Deadline";
            String body = "Dear " + task.getUser().getUsername() + ",\n\nYour task '" + task.getTitle() +
                    "' is due on " + task.getDeadline() + ".\n\nBest regards,\nYour Task Manager";
            try {
                emailService.sendEmail(task.getUser().getEmail(), subject, body);
            } catch (Exception e) {
            }
        }
    }
}
