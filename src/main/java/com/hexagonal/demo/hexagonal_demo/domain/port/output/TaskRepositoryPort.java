package com.hexagonal.demo.hexagonal_demo.domain.port.output;

import com.hexagonal.demo.hexagonal_demo.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {

    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    Optional<Task> update(Task task);

    boolean deleteById(Long id);

}
