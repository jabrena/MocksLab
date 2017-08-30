package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsoleServiceTest {

    @MockBean
    ConsoleService simpleService;

    @Test
    public void hello() throws Exception {

        when(simpleService.hello(anyString())).thenReturn("hello world");

        assertThat(simpleService.hello("world"), is("hello world"));
    }

}