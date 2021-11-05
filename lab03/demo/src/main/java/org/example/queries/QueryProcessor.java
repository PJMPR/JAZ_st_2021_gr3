package org.example.queries;

import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.survive.criteria.*;
import org.example.queries.survive.SurvivorInterface;
import org.example.queries.survive.criteria.counters.CounterController;

import java.util.List;

public class QueryProcessor {

    // List<SurvivorInterface> survivor = List.of(
    //         new SurviveByAge(),
    //         new SurviveByGender(),
    //         new SurviveByIncome(),
    //         new SurviveByName(),
    //         new SurviveBySurname(),
    //         new SurviveByPage()
    // );

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();
        CounterController counterController = new CounterController(result, parameters);
        // Setting all personal data
        result.setItems(People.Data);

        //survivor.forEach(filter -> filter.doSelection(parameters, result));
        result.setItems(new SurviveByAge().doSelection(parameters, result));
        result.setItems(new SurviveByGender().doSelection(parameters, result));
        result.setItems(new SurviveByIncome().doSelection(parameters, result));
        result.setItems(new SurviveByName().doSelection(parameters, result));
        result.setItems(new SurviveBySurname().doSelection(parameters, result));
        result.setItems(new SurviveByPage().doSelection(parameters, result));

        counterController.counterMaker();



        return result;
    }
}
