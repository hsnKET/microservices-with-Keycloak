package me.ketlas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
@Data
public class ConsulConfiguration {

    private Long refreshTokenTimeout;
    private Long accessTokenTimeout;
}
