package com.karollotkowski.cleancode.repositories;

import com.karollotkowski.cleancode.core.Rule;

import java.util.Optional;

public interface RulesRepository {

    Optional<Rule> random();
}
