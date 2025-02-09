package dev.orisha.central_config.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@RestController
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    @Value("${message:fallback message}")
    private String message;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public HomeController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public Map<Object, Object> test() throws IOException {
        log.info("Default message: {}", message);
        String messageUrl = "http://localhost:8773/central-config/default";
        log.info("Fetching configs from {}", messageUrl);
        ResponseEntity<String> response = restTemplate.getForEntity(messageUrl, String.class);
        String responseBody = response.getBody();
        log.info("Configs response: {}", responseBody);
        Response value = objectMapper.readValue(responseBody, Response.class);
        byte[] bytes = objectMapper.writeValueAsBytes(value.getPropertySources().getFirst());
        Response.Data v1 = objectMapper.readValue(bytes, Response.Data.class);
        return Map.of("response", v1);
    }

//    String appConfigsUrl = "http://localhost:8773/central-config/default";
//    String configsUrls = "http://localhost:8773/";



}
