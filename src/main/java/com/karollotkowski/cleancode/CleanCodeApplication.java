package com.karollotkowski.cleancode;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CleanCodeApplication extends Application<AppConfiguration> {

    public static final Logger LOGGER = LoggerFactory.getLogger(CleanCodeApplication.class);

    public static void main(final String[] args) throws Exception {
        new CleanCodeApplication().run(args);
    }

    @Override
    public void run(final AppConfiguration configuration, final Environment environment)
            throws Exception {

        LOGGER.info("Application name: {}", configuration.getAppName());
    }
}
