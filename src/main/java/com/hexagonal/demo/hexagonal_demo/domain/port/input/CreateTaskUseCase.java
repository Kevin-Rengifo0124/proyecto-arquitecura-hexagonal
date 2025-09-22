package com.hexagonal.demo.hexagonal_demo.domain.port.input;

import com.hexagonal.demo.hexagonal_demo.domain.model.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);

}
