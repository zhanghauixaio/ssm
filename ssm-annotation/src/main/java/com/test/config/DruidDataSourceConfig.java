package com.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@MapperScan(basePackages = "com.test.dao")
public class DruidDataSourceConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        final DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        final PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(patternResolver.getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.test.pojo");

        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public TransactionInterceptor transactionInterceptor() {
        final TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        transactionInterceptor.setTransactionManager(dataSourceTransactionManager());

        final Properties transactionAttributes = new Properties();
        transactionAttributes.setProperty("save*", "PROPAGATION_REQUIRED");
        transactionAttributes.setProperty("del*", "PROPAGATION_REQUIRED");
        transactionAttributes.setProperty("update*", "PROPAGATION_REQUIRED");
        transactionAttributes.setProperty("get*", "PROPAGATION_REQUIRED,readOnly");
        transactionAttributes.setProperty("find*", "PROPAGATION_REQUIRED,readOnly");
        transactionAttributes.setProperty("*", "PROPAGATION_REQUIRED");
        transactionInterceptor.setTransactionAttributes(transactionAttributes);

        return transactionInterceptor;
    }
}
