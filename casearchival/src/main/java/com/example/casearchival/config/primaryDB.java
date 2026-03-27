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

//your bean name must be entityManagerFactor otherwise spring will not recognize it,
// however here the bean name is casearchEntityManger.
// So to have our own bean name and yet want the spring to pick it up,
// we need @EnableJpaRepository and configure entityManagerFactorRef = "bean name"

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.example.casearchival.repoPrimary",
            entityManagerFactoryRef = "primaryDbEntityManager",
            transactionManagerRef = "primaryDbTransactionManager"
    )

    public class primaryDB{

        @Bean
        @ConfigurationProperties("spring.datasource.primary-db")
        @Primary
        public DataSource primaryDbDataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean
        @Primary
        public LocalContainerEntityManagerFactoryBean primaryDbEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("primaryDbDataSource")DataSource datasource){
            return builder
                    .dataSource(datasource)
                    .packages(CaseDetails.class)
                    .persistenceUnit("PrimaryDB")
                    .build();
        }

        @Bean
        @Primary
        public PlatformTransactionManager primaryDbTransactionManager(@Qualifier("primaryDbEntityManager") EntityManagerFactory emf){
            return new JpaTransactionManager(emf);
        }
    }

