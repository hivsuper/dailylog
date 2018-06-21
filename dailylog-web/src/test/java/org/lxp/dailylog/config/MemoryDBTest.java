package org.lxp.dailylog.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = { TestDataSourceConfig.class, DataSourceConfig.class })
@TestPropertySource(locations = { "classpath:application.properties", "classpath:test-application.properties" })
@WebAppConfiguration
public @interface MemoryDBTest {
}
