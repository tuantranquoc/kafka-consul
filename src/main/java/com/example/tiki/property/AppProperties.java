package com.example.tiki.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "tiki")
@Data
public class AppProperties {
    private String username;
    private String password;
}
