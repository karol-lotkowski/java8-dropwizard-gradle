package com.karollotkowski.cleancode.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karollotkowski.cleancode.core.Rule;
import io.dropwizard.jackson.Jackson;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JsonFileRulesRepository implements RulesRepository {

    private static final String RULES_FILE = "rules.json";
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    private final List<Rule> rules;

    public JsonFileRulesRepository() {
        rules = fetchRules();

        System.out.println("Number of defined rules: " + rules.size());
    }

    @Override
    public Optional<Rule> random() {
        Collections.shuffle(rules);
        return Optional.ofNullable(rules.iterator().next());
    }

    private List<Rule> fetchRules() {
        final URL rulesResource = getClass().getClassLoader().getResource(RULES_FILE);
        try {
            return MAPPER.readValue(rulesResource, new TypeReference<ArrayList<Rule>>() {});
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
