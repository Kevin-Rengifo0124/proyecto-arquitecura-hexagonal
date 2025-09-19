package com.hexagonal.demo.hexagonal_demo.application.usecase;

import com.hexagonal.demo.hexagonal_demo.domain.port.input.DeleteTaskUseCase;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }
}
