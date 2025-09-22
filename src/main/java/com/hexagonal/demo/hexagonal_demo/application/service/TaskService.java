package com.hexagonal.demo.hexagonal_demo.application.service;

import com.hexagonal.demo.hexagonal_demo.domain.model.AdditionalTaskInfo;
import com.hexagonal.demo.hexagonal_demo.domain.model.Task;
import com.hexagonal.demo.hexagonal_demo.domain.port.input.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class TaskService implements CreateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase, RetrieveTaskUseCase, UpdateTaskUseCase {

    private final CreateTaskUseCase createTaskUseCase;

    private final DeleteTaskUseCase deleteTaskUseCase;

    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    private final RetrieveTaskUseCase retrieveTaskUseCase;

    private final UpdateTaskUseCase updateTaskUseCase;

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return updateTaskUseCase.updateTask(id, updateTask);
    }
}
