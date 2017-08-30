package spring;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by jabrena on 30/8/17.
 */
public @Slf4j class SimpleServiceImpl implements SimpleService {

    @Override
    public String hello(String name) {

        LOGGER.info("Executing method Hello");
        return "hello " + name;
    }
}
