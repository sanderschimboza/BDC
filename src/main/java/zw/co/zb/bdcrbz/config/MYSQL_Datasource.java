package zw.co.zb.bdcrbz.config;

/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = {"zw.co.zb.bdcrbz.repository.OnlineRepo"},

        entityManagerFactoryRef = "db1EntityManager", transactionManagerRef = "db1TransactionManager")
@EnableTransactionManagement
public class MYSQL_Datasource {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean db1EntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(db1Datasource());
        em.setPackagesToScan("zw.co.zb.bdcrbz.model");
        em.setPersistenceUnitName("db1EntityManager");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getProperty("db1.hibernate.dialect"));
        properties.put("hibernate.show-sql", env.getProperty("db1.show-sql"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "db1.datasource")
    public DataSource db1Datasource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db1.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("db1.datasource.url"));
        dataSource.setUsername(env.getProperty("db1.datasource.username"));
        dataSource.setPassword(env.getProperty("db1.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager db1TransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                db1EntityManager().getObject());
        return transactionManager;
    }

}