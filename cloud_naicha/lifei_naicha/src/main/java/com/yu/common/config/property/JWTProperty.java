package com.yu.common.config.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
public class JWTProperty {
    @Value("${my.properties.jwt.secret}")
    private String secret;

}
