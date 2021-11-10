package org.example.queries;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public interface Criteria {
    void setParameters(SearchParameters parameters);
    void meetCriteria(Results results);
}
