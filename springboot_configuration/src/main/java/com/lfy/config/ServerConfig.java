package com.lfy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@Component
@ConfigurationProperties(prefix = "servers")
public class ServerConfig {
    private String ipAddress;
    private int port;
    private long timeout;
}
