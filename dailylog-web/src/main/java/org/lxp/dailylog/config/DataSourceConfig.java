package org.lxp.dailylog.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { DataSourceConfig.BASE_PACKAGES })
@MapperScan(basePackages = DataSourceConfig.MAPPER_PACKAGES, sqlSessionTemplateRef = DataSourceConfig.SQL_SESSION_TEMPLATE)
public class DataSourceConfig {
    public static final String BASE_PACKAGES = "org.lxp.dailylog";
    public static final String MAPPER_PACKAGES = "org.lxp.dailylog.dao.mapper";
    public static final String SQL_SESSION_TEMPLATE = "sqlSessionTemplate";
    public static final String TRANSACTION_MANAGER = "transactionManager";
    private static final String SQL_SESSION_FACTORY = "sqlSessionFactory";
    private static final String TX_ADVICE = "txAdvice";
    @Resource
    private DataSource dataSource;

    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManagerSecondary() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = SQL_SESSION_TEMPLATE)
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(SQL_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public AspectJExpressionPointcutAdvisor pointcutAdvisor(
            @Qualifier(TX_ADVICE) TransactionInterceptor transactionInterceptor) {
        AspectJExpressionPointcutAdvisor pointcutAdvisor = new AspectJExpressionPointcutAdvisor();
        pointcutAdvisor.setAdvice(transactionInterceptor);
        pointcutAdvisor.setExpression("execution (* org.lxp.dailylog..service.*.*(..))");
        return pointcutAdvisor;
    }

    /**
     * http://www.roncoo.com/article/detail/129836
     */
    @Bean(name = TX_ADVICE)
    public TransactionInterceptor transactionInterceptor(
            @Qualifier(TRANSACTION_MANAGER) PlatformTransactionManager transactionManager) throws Exception {
        Properties attributes = new Properties();
        attributes.setProperty("add*", "PROPAGATION_REQUIRED,ISOLATION_DEFAULT");
        attributes.setProperty("update*", "PROPAGATION_REQUIRED,ISOLATION_DEFAULT");
        attributes.setProperty("delete*", "PROPAGATION_REQUIRED,ISOLATION_DEFAULT");
        attributes.setProperty("query*", "PROPAGATION_REQUIRED,ISOLATION_DEFAULT,readOnly");
        attributes.setProperty("*", "PROPAGATION_REQUIRED,ISOLATION_DEFAULT,readOnly");
        return new TransactionInterceptor(transactionManager, attributes);
    }
}