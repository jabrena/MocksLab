package spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public @Slf4j class ConsoleApp implements CommandLineRunner {

    private SimpleService simpleService;

    public ConsoleApp(SimpleService simpleService){
        this.simpleService = simpleService;
    }

    @Override
    public void run(String[] args) {
        LOGGER.info("Running");

        if (args.length > 0) {
            LOGGER.info(simpleService.hello(args[0].toString()));
        } else {
            LOGGER.info(simpleService.hello("world"));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApp.class, args);
    }
}
