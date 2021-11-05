package org.example.filters;

import org.example.queries.results.Results;
import java.util.stream.Collectors;

public record NameFilter(String name) implements FiltrationCriteria{

    @Override
    public void Filtration(Results results) {
        if (name != null) {
            results.setItems(results.getItems().stream()
                    .filter(p -> p.getName().equals(name))
                    .collect(Collectors.toList()));
        }
    }
}
