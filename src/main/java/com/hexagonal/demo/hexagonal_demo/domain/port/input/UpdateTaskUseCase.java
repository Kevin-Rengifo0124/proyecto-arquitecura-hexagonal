package com.hexagonal.demo.hexagonal_demo.domain.port.input;

import com.hexagonal.demo.hexagonal_demo.domain.model.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {

    Optional<Task> updateTask(Long id, Task updateTask);

}
