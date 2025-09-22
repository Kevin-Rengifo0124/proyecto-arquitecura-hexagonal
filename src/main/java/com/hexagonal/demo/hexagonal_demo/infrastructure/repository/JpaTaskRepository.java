package com.hexagonal.demo.hexagonal_demo.infrastructure.repository;

import com.hexagonal.demo.hexagonal_demo.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {


}
