package com.example.casearchival.config;

import com.example.casearchival.model.CaseDetails;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.casearchival.repoArchival",
        entityManagerFactoryRef = "archDbEntityManager",
        transactionManagerRef = "archDbTransactionManager"
)

public class ArchivalDB {

    @Bean
    @ConfigurationProperties("spring.datasource.archival-db")
    public DataSource archDbDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean archDbEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("archDbDataSource")DataSource datasource){
        return builder
                .dataSource(datasource)
                .packages(CaseDetails.class)
                .persistenceUnit("ArchivalDB")
                .build();
    }

    @Bean
    public PlatformTransactionManager archDbTransactionManager(@Qualifier("archDbEntityManager") EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
