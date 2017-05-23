package com.jorgehernandezramirez.unit.rules;

import com.jorgehernandezramirez.unit.rules.custom.CustomLogTestRule;
import com.jorgehernandezramirez.unit.rules.custom.annotation.CustomAnnotation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomLogRuleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomLogRuleTest.class);

    @Rule
    public CustomLogTestRule timeout = CustomLogTestRule.build();

    @CustomAnnotation("test 1")
    @Test
    public void shouldBeTrue() {
        LOGGER.info("Executing test 1...");
        assertTrue(true);
    }

    @CustomAnnotation("test 2")
    @Test
    public void shouldBeFalse() {
        LOGGER.info("Executing test 2...");
        assertFalse(false);
    }
}
