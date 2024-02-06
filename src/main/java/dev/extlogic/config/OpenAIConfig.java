package dev.extlogic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfig {

    @Value("${openai.api.key}")
    private String apiKey;

    @Bean
    public RestTemplate template(){
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((req, body, execution)-> {
            req.getHeaders().add("Authorization", "Bearer "+apiKey);
            return execution.execute(req, body);
        });


        return restTemplate;
    }
}
