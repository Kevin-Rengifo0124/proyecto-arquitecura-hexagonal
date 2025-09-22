package com.hexagonal.demo.hexagonal_demo.domain.port.input;

import com.hexagonal.demo.hexagonal_demo.domain.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo(Long id);

}
