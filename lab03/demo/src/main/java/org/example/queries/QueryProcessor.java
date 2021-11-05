package org.example.queries;

import org.example.model.People;
import org.example.queries.Criteria.*;
import org.example.queries.Functions.AverageFunction;
import org.example.queries.Functions.SumFunctions;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {

    public List<Criteria> criteria = List.of(
      new AgeToCriteria(),
      new AgeFromCriteria(),
      new GenderCriteria(),
      new IncomeFromCriteria(),
      new IncomeToCriteria(),
      new NameCriteria(),
      new SurnameCriteria(),
      new PageCriteria(),
      new AverageFunction(),
      new SumFunctions()
    );

    public Results GetResults(SearchParameters searchParameters){

        Results results = new Results();
        //https://www.tutorialspoint.com/design_pattern/filter_pattern.htm
        results.setItems(People.Data);
        criteria.forEach(criteria -> criteria.meetCriteria(results, searchParameters));
        return results;
    }
}
