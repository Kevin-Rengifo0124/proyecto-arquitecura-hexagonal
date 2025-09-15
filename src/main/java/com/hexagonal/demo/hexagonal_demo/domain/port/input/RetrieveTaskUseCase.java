package com.hexagonal.demo.hexagonal_demo.domain.port.input;

import com.hexagonal.demo.hexagonal_demo.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Optional<Task> getTask(Long id);

    List<Task> getAllTasks();

}
