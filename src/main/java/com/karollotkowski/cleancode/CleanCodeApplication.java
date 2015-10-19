package com.karollotkowski.cleancode;

import com.karollotkowski.cleancode.repositories.JsonFileRulesRepository;
import com.karollotkowski.cleancode.resources.RulesResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CleanCodeApplication extends Application<AppConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CleanCodeApplication.class);

    public static void main(final String[] args) throws Exception {
        new CleanCodeApplication().run(args);
    }

    @Override
    public void run(final AppConfiguration configuration, final Environment environment)
            throws Exception {
        LOGGER.info("Starting application with name: {}", configuration.getAppName());

        final JsonFileRulesRepository rulesRepository = new JsonFileRulesRepository();
        final RulesResource rulesResource = new RulesResource(rulesRepository);

        environment.jersey().register(rulesResource);
    }
}
