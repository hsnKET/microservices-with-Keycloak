package me.ketlas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
@Data
public class VaultConfiguration {

    private String username;
    private String password;
    private String otp;
}
