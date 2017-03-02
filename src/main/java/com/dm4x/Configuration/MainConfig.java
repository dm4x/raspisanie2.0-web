package com.dm4x.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.dm4x.service.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


/**
 * Created by kiselev on 22.02.17.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.dm4x")
public class MainConfig {

    @Bean(name="userDetailsServiceImpl")
    public UserDetailsServiceImpl userDetailsServiceImpl(){
        return new UserDetailsServiceImpl();
    }

    @Bean(name="encoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Bean(name="messageSource")
    public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource(){
        final ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasenames("classpath:validation");
        return reloadableResourceBundleMessageSource;
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        final InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/static/pages/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }


    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix="app.datasource")
    public DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        return dataSource;
    }


    @Bean(name = "entityManagerFactory")
    @ConfigurationProperties(prefix="hibernate")
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("com.dm4x");
        em.setDataSource(getDriverManagerDataSource());
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        ((HibernateJpaVendorAdapter)vendorAdapter).setGenerateDdl(true);
        ((HibernateJpaVendorAdapter)vendorAdapter).setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean(name = "jpaTransactionManager")
    public JpaTransactionManager getJpaTransactionManager() {
        JpaTransactionManager jpa = new JpaTransactionManager();
        jpa.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean().getNativeEntityManagerFactory());
        return jpa;
    }

}
