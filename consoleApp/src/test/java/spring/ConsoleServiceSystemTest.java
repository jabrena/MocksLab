package spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsoleAppConfiguration.class)
public @Slf4j class ConsoleServiceSystemTest {

    @Autowired
    ConsoleService simpleService;

    @Test
    public void hello() throws Exception {
        assertThat(simpleService.hello("world"), is("hello world"));
    }

}