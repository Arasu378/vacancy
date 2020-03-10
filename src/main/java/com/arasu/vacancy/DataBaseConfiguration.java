package com.arasu.vacancy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DataBaseConfiguration {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDB() {
        logger.info("DEV DB");
        logger.info("URL : : " + url);
        logger.info("UserName : : " + username);
        logger.info("Password : : " + password);
        return "DataBase in DEV environment";
    }

    @Profile("prod")
    @Bean
    public String prodDB() {
        logger.info("PROD DB");
        logger.info("URL : : " + url);
        logger.info("UserName : : " + username);
        logger.info("Password : : " + password);
        return "DataBase in PROD environment";
    }
}
