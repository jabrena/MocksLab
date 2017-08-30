package spring;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;
import static org.mockito.Matchers.anyString;

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

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void helloWithBadArgument() throws Exception {
        expectedException.expect(ConsoleBusinessException.class);
        expectedException.expectMessage("Bad Name");

        given(simpleService.hello(anyString())).willThrow(new ConsoleBusinessException("Bad Name"));

        //This is an example which a Mock doesn´t rise the exception by the right nature
        when(simpleService.hello(""));

        //then
    }

}