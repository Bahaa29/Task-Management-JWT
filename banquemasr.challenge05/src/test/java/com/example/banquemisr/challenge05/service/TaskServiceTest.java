package com.example.banquemisr.challenge05.service;


import com.example.banquemisr.challenge05.model.Task;
import com.example.banquemisr.challenge05.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    private Task task;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        task = new Task();
        task.setId(1L);
        task.setTitle("Sample Task");
        task.setDescription("This is a sample task");
        task.setStatus("todo");
        task.setPriority("high");
        task.setDeadline(LocalDate.now().atStartOfDay());
    }

    @Test
    public void testCreateTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        Task createdTask = taskService.createTask(task);
        assertNotNull(createdTask);
        assertEquals(task.getTitle(), createdTask.getTitle());
    }

    @Test
    public void testGetTask() {
        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        Task foundTask = taskService.getTask(1L);
        assertNotNull(foundTask);
        assertEquals(task.getTitle(), foundTask.getTitle());
    }

    @Test
    public void testUpdateTask() {
        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        Task updatedTask = taskService.updateTask(1L, task);
        assertNotNull(updatedTask);
        assertEquals(task.getTitle(), updatedTask.getTitle());
    }

    @Test
    public void testDeleteTask() {
        doNothing().when(taskRepository).deleteById(anyLong());
        taskService.deleteTask(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }
}
