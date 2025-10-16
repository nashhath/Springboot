package com.example.mockito.repository;

import java.util.List;

import com.example.mockito.model.Task;

public interface TaskRepository{
	List<Task> findAll();
	Task save(Task task);
	
}