package spring;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by jabrena on 30/8/17.
 */
public @Slf4j class ConsoleServiceImpl implements ConsoleService {

    private final String BAD_NAME = "BAD_NAME";

    @Override
    public String hello(final String name) throws ConsoleBusinessException {

        LOGGER.info("Executing method Hello");
        if(name.equals(BAD_NAME)) {
            throw new ConsoleBusinessException("Bad Name");
        }
        return "hello " + name;
    }
}
