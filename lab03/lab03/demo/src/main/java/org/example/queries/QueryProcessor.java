package org.example.queries;

import org.example.criteria.*;
import org.example.functions.Functions;
import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {


        List<Criteria> criteriaList = List.of(
                new FromAge(),
                new FromIncome(),
                new Gender(),
                new Name(),
                new Surname(),
                new ToAge(),
                new ToIncome()
        );
    public Results GetResults(SearchParameters parameters){
        Functions functions = new Functions();
        Results result = new Results();
        result.setItems(People.Data);

        criteriaList.forEach(filter -> filter.meetCriteria(result, parameters));
        functions.all(result,parameters);






        return result;








}
}



