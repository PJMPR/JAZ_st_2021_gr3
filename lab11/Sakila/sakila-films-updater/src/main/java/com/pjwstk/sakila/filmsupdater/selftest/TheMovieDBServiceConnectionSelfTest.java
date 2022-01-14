package com.pjwstk.sakila.filmsupdater.selftest;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import com.pjwstk.sakila.diagnostics.selftest.SelfTestBase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class TheMovieDBServiceConnectionSelfTest extends SelfTestBase {
    @Value("${tmdb.api.key}")String apiKey;
    private final RestTemplate rest = new RestTemplate();

    public TheMovieDBServiceConnectionSelfTest() {
        name = "TheMovieDbServiceConnectionSelfTest";
        description = "Checks connection to TheMovieDB API.";
    }

    @Override
    public SelfTestResult execute() {
        SelfTestResult selftestResult = new SelfTestResult(name, description, false, null);
        try{
            var movie = rest.getForEntity("https://api.themoviedb.org/3/movie/" +
                    1122 +
                    "?api_key=" + apiKey, Object.class).getBody();
            System.out.println(movie);
            selftestResult.setPassed(true);
        } catch (HttpClientErrorException e){
            selftestResult.setPassed(false);
            selftestResult.setErrors(Arrays.asList(e.getMessage()));
        }

        return selftestResult;
    }
}
