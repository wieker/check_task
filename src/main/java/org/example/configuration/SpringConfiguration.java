package org.example.configuration;

import org.example.service.DateTimeProvider;
import org.joda.time.DateTime;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class SpringConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return DateTime::new;
    }
}
