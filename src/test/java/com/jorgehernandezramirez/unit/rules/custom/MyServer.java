package com.jorgehernandezramirez.unit.rules.custom;

import org.junit.rules.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServer extends ExternalResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServer.class);

    @Override
    protected void before() throws Throwable {
        LOGGER.info("Starting the server...");
    }

    @Override
    protected void after() {
        LOGGER.info("Shutdown the server...");
    }
}
