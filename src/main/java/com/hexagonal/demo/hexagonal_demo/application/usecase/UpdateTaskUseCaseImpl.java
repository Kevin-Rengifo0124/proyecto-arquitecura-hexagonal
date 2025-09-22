package com.hexagonal.demo.hexagonal_demo.application.usecase;

import com.hexagonal.demo.hexagonal_demo.domain.model.Task;
import com.hexagonal.demo.hexagonal_demo.domain.port.input.UpdateTaskUseCase;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }
}
