package org.lxp.dailylog.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = DataSourceConfig.BASE_PACKAGES, sqlSessionTemplateRef = DataSourceConfig.SQL_SESSION_TEMPLATE)
public class DataSourceConfig {
    public static final String BASE_PACKAGES = "org.lxp.dailylog.dao.mapper";
    public static final String MAPPER_XML_PATH = "classpath:org/lxp/dailylog/dao/mapper/*/*.xml";
    public static final String SQL_SESSION_TEMPLATE = "sqlSessionTemplate";
    private static final String SQL_SESSION_FACTORY = "sqlSessionFactory";
    @Resource
    private DataSource dataSource;

    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH));
        return bean.getObject();
    }

    @Bean(name = SQL_SESSION_TEMPLATE)
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(SQL_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}