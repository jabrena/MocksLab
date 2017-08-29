package spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConsoleApp {

    public static void main(String[] args){

        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(ConsoleApp.class)
                .run(args);

        ConsoleApp app = context.getBean(ConsoleApp.class);
        app.start();

    }

    private void start() {
        System.out.println("Hello World!");
    }

}
