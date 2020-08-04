package com.github.dingey.auth;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnBean(MybatisAutoConfiguration.class)
public class AuthMybatisConfiguration {
    private static final Logger log = LoggerFactory.getLogger(AuthMybatisConfiguration.class);

    @PostConstruct
    public void init() {
        log.info("Initializing Auth Mybatis Service");
    }
}
