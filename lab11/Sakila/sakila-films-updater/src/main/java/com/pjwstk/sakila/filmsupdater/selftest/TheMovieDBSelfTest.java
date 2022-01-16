package com.pjwstk.sakila.filmsupdater.selftest;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import com.pjwstk.sakila.diagnostics.selftest.SelfTestBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TheMovieDBSelfTest extends SelfTestBase {
    @Value("${tmdb.api.key}")
    String apiKey;

    @Override
    public SelfTestResult execute() {
        List<String> errors = new ArrayList<>();
        SelfTestResult selftestResult = new SelfTestResult("TheMovieDBSelfTest", "Checks if connection with TheMovieDB is possible.", false, errors);
        selftestResult.getErrors().add("Not finished yet");

        return selftestResult;
    }
}