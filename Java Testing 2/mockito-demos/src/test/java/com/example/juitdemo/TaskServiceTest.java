package com.example.juitdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.mockito.model.Task;
import com.example.mockito.repository.TaskRepository;
import com.example.mockito.service.TaskService;

@ExtendWith(MockitoExtension.class)  
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        // MockitoExtension takes care of mock initialization
    }

    @Test
    void testAddTask() {
        Task task = new Task(1, "LearnMockito");

        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.addTask(task);

        assertEquals("LearnMockito", result.getName());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testAddTaskWithEmptyName() {
        Task task = new Task(2, " ");

        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task));
        verify(taskRepository, never()).save(any());
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Arrays.asList(
                new Task(1, "A"),
                new Task(2, "B")
        );

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAlltasks();

        assertEquals(2, result.size());
        verify(taskRepository, times(1)).findAll();
    }
}
