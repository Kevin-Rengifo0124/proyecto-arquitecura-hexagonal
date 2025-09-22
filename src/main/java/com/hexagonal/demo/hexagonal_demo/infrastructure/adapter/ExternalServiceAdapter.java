package com.hexagonal.demo.hexagonal_demo.infrastructure.adapter;

import com.hexagonal.demo.hexagonal_demo.domain.model.AdditionalTaskInfo;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.ExternalServicePort;
import lombok.Data;

public class ExternalServiceAdapter implements ExternalServicePort {


    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return null;
    }

    @Data
    private static class JsonPlaceHolderEveryone {
        private Long id;
        private Long userId;
    }

    @Data
    private static class JsonPlaceHolderUser {
        private Long id;
        private String name;
        private String email;
    }
}
