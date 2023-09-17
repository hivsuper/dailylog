package org.lxp.dailylog.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class TestDataSourceConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().generateUniqueName(true).setType(EmbeddedDatabaseType.H2)
                .continueOnError(false).setSeparator(";;").addScript("memory-db-schema.sql")
                .addScript("memory-db-data.sql").build();
        return dataSource;
    }
}
