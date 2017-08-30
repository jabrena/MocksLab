package spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public @Slf4j class SimpleServiceSystemTest {

    @Configuration
    static class SimpleServiceConfiguration {

        @Bean
        public SimpleService simpleService() {
            return new SimpleServiceImpl();
        }

    }

    @Autowired
    SimpleService simpleService;

    @Test
    public void hello() throws Exception {
        assertThat(simpleService.hello("world"), is("hello world"));
    }

}