package spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public @Slf4j class ConsoleApp {

    private SimpleService simpleService;

    public ConsoleApp(SimpleService simpleService){
        this.simpleService = simpleService;
    }

    public static void main(String[] args){

        SpringApplication app = new SpringApplication(ConsoleApp.class);
        app.run(args);

    }

    private void run(String[] args) {

        LOGGER.info("Running");

        if (args.length > 0) {
            LOGGER.info(simpleService.hello(args[0].toString()));
        } else {
            LOGGER.info(simpleService.hello("world"));
        }

        System.exit(0);
    }

}
