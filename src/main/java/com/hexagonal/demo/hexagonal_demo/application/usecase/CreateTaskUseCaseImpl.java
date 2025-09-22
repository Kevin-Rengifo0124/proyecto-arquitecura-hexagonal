package com.hexagonal.demo.hexagonal_demo.application.usecase;

import com.hexagonal.demo.hexagonal_demo.domain.model.Task;
import com.hexagonal.demo.hexagonal_demo.domain.port.input.CreateTaskUseCase;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
