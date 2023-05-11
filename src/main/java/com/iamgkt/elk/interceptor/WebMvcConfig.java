package com.iamgkt.elk.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("Adding CorrelationIdInterceptor");
        registry.addInterceptor(correlationIdInterceptor());
    }

    @Bean
    public CorrelationIdInterceptor correlationIdInterceptor() {
        return new CorrelationIdInterceptor();
    }
}
