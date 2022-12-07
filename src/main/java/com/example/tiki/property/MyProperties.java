package com.example.tiki.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "my")
@Data
public class MyProperties {
    private String username;
    private String password;
    private String key;
}
