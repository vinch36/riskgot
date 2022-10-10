package com.vinch36.frontendjava.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.vinch36.frontendjava")
@Data
public class CustomProperties {
    private String apiUrl;
}
