package com.erosproject.erosdatabase.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Setter
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.erosproject.erosdatabase.repository" })
@ConfigurationProperties(prefix = "eros.database")
@Log4j2
public class DatabaseConfig {
    private String url;
    private String driverClassName;
    private String username;
    private String secret;
    private String poolName;
    private Integer maxPoolSize;
    private Integer minPoolSize;
    private Integer maxLifetime;
    private Integer validationTimeout;
    private String schema;

    @Bean(name = "datasource")
    public DataSource dataSourceEros() {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(extractSecretValue(username));
        hikariConfig.setPassword(extractSecretValue(secret));
        hikariConfig.setPoolName(poolName);
        hikariConfig.setMinimumIdle(minPoolSize);
        hikariConfig.setMaximumPoolSize(maxPoolSize);
        hikariConfig.setMaxLifetime(maxLifetime);
        hikariConfig.setValidationTimeout(validationTimeout);
        hikariConfig.setSchema(schema);

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactoryEros() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan("com.erosproject.database");
        factory.setDataSource(dataSourceEros());
        factory.setJpaPropertyMap(jpaProperties());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManagerEros() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactoryEros());
        return transactionManager;
    }

    protected Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        return props;
    }

    private static String extractSecretValue(String secret) {
        Path secretPath = Path.of(secret);
        try {
            log.info(Files.readString(secretPath));
            return Files.readString(secretPath);
        } catch (IOException e) {
            log.info(secret);
            return secret;
        }
    }
}
