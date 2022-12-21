package com.musala.soft.repo;

import com.musala.soft.repo.services.CoreDroneService;
import com.musala.soft.repo.services.CoreDroneServiceImpl;
import com.musala.soft.repo.services.CoreMedicationService;
import com.musala.soft.repo.services.CoreMedicationServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.musala.soft.repo.repository")
@EntityScan({"com.musala.soft.entity.drones"})
public class CoreDroneAutoConfiguration {
    @Bean
    @ConfigurationProperties("core.service.db")
    @ConditionalOnMissingBean
    public DataSource coreDataSource(){
        return new DriverManagerDataSource();
    }

    @Bean
    @ConditionalOnMissingBean
    public JdbcTemplate coreDataSourceJdbcTemplate(){
        return new JdbcTemplate(coreDataSource());
    }

    @Bean
    public CoreDroneService coreDroneService(){
        return new CoreDroneServiceImpl();
    }

    @Bean
    public CoreMedicationService coreMedicationService(){
        return new CoreMedicationServiceImpl();
    }
}
