package pl.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@ComponentScan({
        "pl.util"
})
public class WebAppConfiguration {
    private static Logger logger = LoggerFactory.getLogger(WebAppConfiguration.class.getSimpleName());

    @PostConstruct
    public void postConstruct() {
        logger.info("Created web app configuration class");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("Destroying web app configuration class");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
