package com.hexagonal.demo.hexagonal_demo.infrastructure.adapter;

import com.hexagonal.demo.hexagonal_demo.domain.model.AdditionalTaskInfo;
import com.hexagonal.demo.hexagonal_demo.domain.port.output.ExternalServicePort;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderEveryone> responseEntity = restTemplate.getForEntity(apiUrl, JsonPlaceHolderEveryone.class);

        JsonPlaceHolderEveryone jsonPlaceHolderEveryone = responseEntity.getBody();
        if (jsonPlaceHolderEveryone == null) {
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + jsonPlaceHolderEveryone.getUserId();
        ResponseEntity<JsonPlaceHolderUser> userResponseEntity = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);

        JsonPlaceHolderUser jsonPlaceHolderUser = userResponseEntity.getBody();
        if (jsonPlaceHolderUser == null) {
            return null;
        }
        return new AdditionalTaskInfo(jsonPlaceHolderUser.getId(), jsonPlaceHolderUser.getName(), jsonPlaceHolderUser.email);
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
