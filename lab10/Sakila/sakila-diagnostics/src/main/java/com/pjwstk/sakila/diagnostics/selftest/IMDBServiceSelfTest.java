package com.pjwstk.sakila.diagnostics.selftest;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@AllArgsConstructor
public class IMDBServiceSelfTest extends SelfTestBase {
    @Value("${imdb.api.key}")String apiKey;
    private final RestTemplate rest = new RestTemplate();

    public IMDBServiceSelfTest() {
        name = "ImDBServiceSelfTest";
        description = "Checks connection to imdb";
    }


    @Override
    public SelftestResult execute() {
        SelftestResult selftestResult = new SelftestResult(name, description, false, null);
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("x-rapidapi-host", "imdb8.p.rapidapi.com");
            headers.add("x-rapidapi-key", "${imdbApiKey}");

            HttpEntity<String> entity = new HttpEntity<>("body", headers);

            rest.exchange("https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20thr", HttpMethod.GET, entity, String.class);
            selftestResult.setPassed(true);
        } catch (HttpClientErrorException e){
            selftestResult.setPassed(false);
            selftestResult.setErrors(Arrays.asList(e.getMessage()));
        }

        return selftestResult;
    }
}