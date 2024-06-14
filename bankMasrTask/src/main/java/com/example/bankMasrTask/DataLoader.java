package com.example.bankMasrTask;

import com.example.bankMasrTask.model.Role;
import com.example.bankMasrTask.model.Task;
import com.example.bankMasrTask.model.User;
import com.example.bankMasrTask.repository.RoleRepository;
import com.example.bankMasrTask.repository.TaskRepository;
import com.example.bankMasrTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);

            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setEmail("bahaaeldin390@gmail.com");
            admin.setRoles(Set.of(adminRole));
            userRepository.save(admin);

            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setEmail("paoch537@gmail.com");
            user.setRoles(Set.of(userRole));
            userRepository.save(user);

            // Create a task for the admin user
            /*Task adminTask = new Task();
            adminTask.setTitle("Admin Task");
            adminTask.setDeadline(LocalDateTime.now().plusHours(12)); // Set deadline within 24 hours for testing
            adminTask.setUser(admin);
            taskRepository.save(adminTask);

            // Create a task for the regular user
            Task userTask = new Task();
            userTask.setTitle("User Task");
            userTask.setDeadline(LocalDateTime.now().plusDays(1)); // Set deadline within 24 hours for testing
            userTask.setUser(user);
            taskRepository.save(userTask);*/
        }
    }
}
