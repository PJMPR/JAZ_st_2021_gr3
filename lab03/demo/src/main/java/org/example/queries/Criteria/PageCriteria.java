package org.example.queries.Criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class PageCriteria implements Criteria{
    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        if (searchParameters.getPage() != null) {
            int s = Math.min(searchParameters.getPage().getSize()*(searchParameters.getPage().getPageNumber() - 1), results.getItems().size());
            int s2 = Math.min(searchParameters.getPage().getSize()*(searchParameters.getPage().getPageNumber()), results.getItems().size());
            results.setItems(results.getItems().subList(s, s2));
            results.setCurrentPage(searchParameters.getPage().getPageNumber());
            results.setPages((int) Math.ceil((double) results.getItems().size() / searchParameters.getPage().getSize()));
        }
    }
}
