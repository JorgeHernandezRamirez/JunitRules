package com.jorgehernandezramirez.unit.rules;

import com.jorgehernandezramirez.unit.rules.custom.MyServer;
import com.jorgehernandezramirez.unit.rules.custom.annotation.CustomAnnotation;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyServerClassRuleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServerClassRuleTest.class);

    @ClassRule
    public static MyServer server = new MyServer();

    @Test
    public void shouldBeTrue() {
        LOGGER.info("Executing test 1...");
        assertTrue(true);
    }

    @Test
    public void shouldBeFalse() {
        LOGGER.info("Executing test 2...");
        assertFalse(false);
    }
}
