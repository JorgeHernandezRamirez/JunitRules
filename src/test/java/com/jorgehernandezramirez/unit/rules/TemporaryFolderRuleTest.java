package com.jorgehernandezramirez.unit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TemporaryFolderRuleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemporaryFolderRuleTest.class);

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void shouldCreateNewFileOverTemporaryFolder() throws IOException {
        final File file = temporaryFolder.newFile("spring.png");
        assertTrue(file.exists());
        assertEquals(temporaryFolder.getRoot(), file.getParentFile());
        LOGGER.info("{}", temporaryFolder.getRoot());
    }
}
