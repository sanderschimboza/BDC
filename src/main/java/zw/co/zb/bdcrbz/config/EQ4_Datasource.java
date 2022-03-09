package zw.co.zb.bdcrbz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import java.util.Objects;

@Configuration
@EnableJpaRepositories(basePackages = {"zw.co.zb.bdcrbz.repository.EQ4Repo"},
        entityManagerFactoryRef = "db2EntityManager", transactionManagerRef = "db2TransactionManager")
@EnableTransactionManagement
public class EQ4_Datasource {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean db2EntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(db2Datasource());
        em.setPackagesToScan("zw.co.zb.bdcrbz.model");
        em.setPersistenceUnitName("db2EntityManager");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getProperty("db2.hibernate.dialect"));
        properties.put("hibernate.show-sql", env.getProperty("db2.jpa.show-sql"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    @ConfigurationProperties(prefix = "db2.datasource")
    public DataSource db2Datasource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("db2.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("db2.datasource.url"));
        dataSource.setUsername(env.getProperty("db2.datasource.username"));
        dataSource.setPassword(env.getProperty("db2.datasource.password"));

        return dataSource;
    }

    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager db2TransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                db2EntityManager().getObject());
        return transactionManager;
    }

}