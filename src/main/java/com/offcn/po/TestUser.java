package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@PropertySource("test.properties")
@ConfigurationProperties(prefix = "testuser")
public class TestUser {
    private String name;
    private String password;
    private String birthday;
}
