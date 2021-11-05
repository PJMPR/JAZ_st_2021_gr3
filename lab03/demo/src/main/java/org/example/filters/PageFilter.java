package org.example.filters;

import org.example.queries.results.Results;
import org.example.queries.search.Page;

import java.util.stream.Collectors;

public record PageFilter(Page page) implements FiltrationCriteria {

    @Override
    public void Filtration(Results results) {
        if (page != null) {
            results.setPages(page.calcNeededPages(results));
            results.setCurrentPage(page.getPageNumber());

            results.setItems(results.getItems().stream()
                    .skip(page.calcElementsToSkip(results))
                    .limit(page.getSize())
                    .collect(Collectors.toList()));
        }
    }
}
