package com.example.mockito.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mockito.MockitoDemosApplication;
import com.example.mockito.model.Task;
import com.example.mockito.repository.TaskRepository;

@Service
public class TaskService {
	private TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository,MockitoDemosApplication mockitoDemosApplication)
	{
		this.taskRepository = taskRepository;
	}
	public Task addTask(Task task)
	{
		if(task.getName() == null || task.getName().isBlank())
		{
			throw new IllegalArgumentException("Task name cannot be empty");
		}
		return taskRepository.save(task);
	}
	public List<Task> getAlltasks()
	{
		return taskRepository.findAll();
	}
	
}