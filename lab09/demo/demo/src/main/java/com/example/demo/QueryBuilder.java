package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QueryBuilder {
    public static String buildQuery(Optional<Integer> id,Optional<String> title, Optional<Integer> language, Optional<String> releaseYear,
                                    Optional<String> rentalDuration, Optional<String> rentalRate, Optional<String> replacementCost) {
        List<String> query_finders = new java.util.ArrayList<>();
        id.ifPresent(i -> query_finders.add("film_id = '" + i+"'"));
        title.ifPresent(s -> query_finders.add("title = '" + s+"'"));
        language.ifPresent(integer -> query_finders.add("language_id = '" + integer+"'"));
        releaseYear.ifPresent(s -> query_finders.add("release_year = '" + s+"'"));
        rentalDuration.ifPresent(s -> query_finders.add("rental_duration = '" + s+"'"));
        rentalRate.ifPresent(s -> query_finders.add("rental_rate = '" + s+"'"));
        replacementCost.ifPresent(s -> query_finders.add("replacement_cost = '" + s+"'"));

        String query = "SELECT film FROM Film film ";
        return query_finders.isEmpty() ? query : query_finders.stream().collect(Collectors.joining(" AND ", query + " WHERE ", ""));
    }
}
