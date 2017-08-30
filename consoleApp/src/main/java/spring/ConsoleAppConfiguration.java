package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsoleAppConfiguration {

    @Bean
    public SimpleService simpleService() {
        return new SimpleServiceImpl();
    }

}
