package org.example.criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public interface Criteria {
    public void meetCriteria (Results results, SearchParameters searchParameters);
}
