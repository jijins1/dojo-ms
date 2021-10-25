package com.pharmagest.monalisa.dojo.core.config;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@ComponentScan("com.pharmagest.monalisa.dojo.core.service")
@EnableJpaRepositories(
        basePackages = "com.pharmagest.monalisa.dojo.core.repository"
)
@Slf4j
public class CoreConfig {
    
    /**
     * On defini ou se fait le scan des entity
     * Attention ici le nom de la methode est important
     * @param dataSource
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        log.info("Start Entity Manager");
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.pharmagest.monalisa.dojo.core.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);// Nous on est pas concercé car on utilise liquibase en general. Mais il faudrait faire plus propre
        em.setJpaVendorAdapter(vendorAdapter);
        
        return em;
    }
    
}
