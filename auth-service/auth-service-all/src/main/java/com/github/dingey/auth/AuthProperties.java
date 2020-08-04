package com.github.dingey.auth;

import com.github.dingey.auth.enums.WebType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {
    private boolean enable;
    private WebType webType;
}
