package com.karollotkowski.cleancode.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.concurrent.Immutable;

@Immutable
public class Rule {

    private String title;

    private String description;

    public Rule() {
        // Jackson deserialization
    }

    public Rule(final String title, final String description) {
        this.title = title;
        this.description = description;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }
}
