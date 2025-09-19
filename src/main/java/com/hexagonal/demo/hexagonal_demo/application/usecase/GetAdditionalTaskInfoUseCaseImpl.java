package com.hexagonal.demo.hexagonal_demo.application.usecase;

import com.hexagonal.demo.hexagonal_demo.domain.model.AdditionalTaskInfo;
import com.hexagonal.demo.hexagonal_demo.domain.port.input.GetAdditionalTaskInfoUseCase;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.ExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
