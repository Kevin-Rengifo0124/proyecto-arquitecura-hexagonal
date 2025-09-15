package com.hexagonal.demo.hexagonal_demo.domain.port.output;

import com.hexagonal.demo.hexagonal_demo.domain.model.AdditionalTaskInfo;

public interface ExternalServicePort {

    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);

}
