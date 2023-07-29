package com.frank.flowabledemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "com.miotech.ip.manual-mapping")
@Data
@RefreshScope
public class MyApolloProperties {

    private List<String> usCidr;
}
