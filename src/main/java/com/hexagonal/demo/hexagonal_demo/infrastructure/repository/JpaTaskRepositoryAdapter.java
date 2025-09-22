package com.hexagonal.demo.hexagonal_demo.infrastructure.repository;

import com.hexagonal.demo.hexagonal_demo.domain.model.Task;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.TaskRepositoryPort;
import com.hexagonal.demo.hexagonal_demo.infrastructure.entity.TaskEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> update(Task task) {
        if (jpaTaskRepository.existsById(task.getId())) {
            // convertir dominio → entidad
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            // guardar cambios
            TaskEntity updateTaskEntity = jpaTaskRepository.save(taskEntity);
            // convertir entidad → dominio
            return Optional.of(updateTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaTaskRepository.existsById(id)) {
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
