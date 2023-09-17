package org.lxp.dailylog.config;

import org.lxp.dailylog.web.interceptor.CrossDomainInterceptor;
import org.lxp.dailylog.web.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * https://stackoverflow.com/questions/31082981/spring-boot-adding-http-request-interceptors
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private List<String> excludePaths = Arrays.asList("/login.json", "/logout", "/verifyCode.json", "/version", "/error",
            "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/webjars/**");
    @Value("${frontend.domain}")
    private String domain;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CrossDomainInterceptor(domain)).addPathPatterns("/**");
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(excludePaths).addPathPatterns("/**");
    }
}
