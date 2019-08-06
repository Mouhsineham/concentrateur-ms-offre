package com.sofrecom.sofid.boundedcontext.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofrecom.sofid.framework.exception.FeignClientExceptionErrorDecoder;
import com.sofrecom.sofid.framework.security.UserFeignClientInterceptor;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;

@Configuration
@EnableFeignClients(basePackages = "com.sofrecom.sofid.boundedcontext")
public class FeignConfiguration {

    /**
     * Set the Feign specific log level to log client REST requests.
     */
    @Bean
    feign.Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.BASIC;
    }

    /**
     * Set The Feign specific error decode
     */
    @Bean
    public ErrorDecoder errorDecoder(@Autowired ObjectMapper objectMapper) {
        return new FeignClientExceptionErrorDecoder(objectMapper);
    }

    /**
     * Interceptor that include the received jwt token to outgoing feign request
     * @return
     */
    @Bean
    public RequestInterceptor getSecurityRequestInterceptor() {
        return new UserFeignClientInterceptor();
    }
}
