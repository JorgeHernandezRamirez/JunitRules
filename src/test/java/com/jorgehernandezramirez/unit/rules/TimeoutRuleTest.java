package com.jorgehernandezramirez.unit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TimeoutRuleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutRuleTest.class);

    @Rule
    public Timeout timeout = Timeout.builder().withTimeout(100L, TimeUnit.MILLISECONDS).build();

    @Test
    public void shouldEndUntil100Milliseconds() {
        assertTrue(true);
    }
}
