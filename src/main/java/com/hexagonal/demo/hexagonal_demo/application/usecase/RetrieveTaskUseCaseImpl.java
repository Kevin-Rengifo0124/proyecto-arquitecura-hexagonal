package com.hexagonal.demo.hexagonal_demo.application.usecase;

import com.hexagonal.demo.hexagonal_demo.domain.model.Task;
import com.hexagonal.demo.hexagonal_demo.domain.port.input.RetrieveTaskUseCase;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
