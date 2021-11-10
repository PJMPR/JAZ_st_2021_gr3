package org.example.queries;

import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {

    List<Criteria> criterias = List.of(
            new SimpleCriteria(p->p.getAgeFrom()>0, (person,params)->person.getAge()>params.getAgeFrom()),
            new PagingCriteria(),
    );

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();
        result.setItems(People.Data);
        criterias.stream().forEach(criteria->criteria.meetCriteria(result));

        return result;
    }
}
