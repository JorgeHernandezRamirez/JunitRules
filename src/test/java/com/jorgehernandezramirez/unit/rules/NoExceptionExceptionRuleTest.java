package com.jorgehernandezramirez.unit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertTrue;

public class NoExceptionExceptionRuleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoExceptionExceptionRuleTest.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldEndWithoutAnyException() throws IOException {
        assertTrue(true);
    }

    @Test
    public void shouldEndWithAnException() throws IOException {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("This is an unsupported operation");
        expectedException.expectCause(isA(RuntimeException.class));
        expectedException.reportMissingExceptionWithMessage("This is a");
        throw new UnsupportedOperationException("This is an unsupported operation", new RuntimeException());
    }
}
