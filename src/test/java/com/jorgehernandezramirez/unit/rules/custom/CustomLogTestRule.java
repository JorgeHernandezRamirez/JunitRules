package com.jorgehernandezramirez.unit.rules.custom;

import com.jorgehernandezramirez.unit.rules.custom.annotation.CustomAnnotation;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.Configuration;
import java.lang.annotation.Annotation;

public class CustomLogTestRule implements TestRule {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomLogTestRule.class);

    private static final String EMPTY = "";

    private CustomLogTestRule(){
        super();
    }

    public static CustomLogTestRule build(){
        return new CustomLogTestRule();
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new CustomLogStatement(base, description);
    }

    private class CustomLogStatement extends Statement{

        private final Statement base;

        private final Description description;

        public CustomLogStatement(final Statement base, final Description description){
            this.base = base;
            this.description = description;
        }

        @Override
        public void evaluate() throws Throwable {
            LOGGER.info("Init test -> {}, {}, {}", description.getMethodName(),
                    description.getDisplayName(), getCustomAnnotationValue(description));
            base.evaluate();
            LOGGER.info("End test -> {}, {}, {}", description.getMethodName(),
                    description.getDisplayName(), getCustomAnnotationValue(description));
        }
    }

    private String getCustomAnnotationValue(final Description description){
        final CustomAnnotation customAnnotation = description.getAnnotation(CustomAnnotation.class);
        if(customAnnotation == null){
            return EMPTY;
        }
        return customAnnotation.value();
    }
}
