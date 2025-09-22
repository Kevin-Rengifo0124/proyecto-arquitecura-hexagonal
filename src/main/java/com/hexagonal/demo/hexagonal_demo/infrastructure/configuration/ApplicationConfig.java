package com.hexagonal.demo.hexagonal_demo.infrastructure.configuration;

import com.hexagonal.demo.hexagonal_demo.application.service.TaskService;
import com.hexagonal.demo.hexagonal_demo.application.usecase.*;
import com.hexagonal.demo.hexagonal_demo.domain.port.input.GetAdditionalTaskInfoUseCase;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.ExternalServicePort;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.TaskRepositoryPort;
import com.hexagonal.demo.hexagonal_demo.infrastructure.adapter.ExternalServiceAdapter;
import com.hexagonal.demo.hexagonal_demo.infrastructure.repository.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase,
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort)
        );

    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
