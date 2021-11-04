package org.example.queries;

import org.example.model.People;
import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Criteria.*;

import org.example.queries.search.Functions.Avg;
import org.example.queries.search.Functions.Functions;
import org.example.queries.search.Functions.Sum;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {
    Results result = new Results();
    Functions average = new Avg();
    Functions sum = new Sum();
    List<Criteria> criterias = List.of(
            new NameCriteria(),
            new SurnameCriteria(),

            new GenderCriteria(),

            new MaxAgeCriteria(),
            new MinAgeCriteria(),

            new MinIncomeCriteria(),
            new MaxIncomeCriteria()
    );

    public Results GetResults(SearchParameters parameters) {

        List<Person> filteredPersons = filterPersons(parameters);
        result.setItems(setPages(filteredPersons,parameters));
        result.setFunctionResults(setFunctionsList(filteredPersons,parameters));

        return result;
    }
    private List<Person> filterPersons(SearchParameters parameters){
        List<Person> fullDataSet = People.Data;
        for (Criteria criteria : criterias) {
            fullDataSet = criteria.meetCriteria(fullDataSet, parameters);
        }
        return fullDataSet;
    }

    private List<FunctionResult> setFunctionsList(List<Person> test, SearchParameters parameters){
        List<FunctionResult> functionsParametersList = new ArrayList<>();
        parameters.getFunctions().forEach(functionsParameters -> {
            double effect;
            switch (functionsParameters.getFunction()){
                case AVARAGE -> effect=average.doSth(test,functionsParameters);
                case SUM -> effect=sum.doSth(test,functionsParameters);
                default -> throw new IllegalStateException("Unexpected value: " + functionsParameters.getFunction());
            }
            functionsParametersList.add(new FunctionResult(functionsParameters.getFunction(),functionsParameters.getFieldName(), effect));
        });

        return functionsParametersList;
    }

    private List<Person> setPages(List<Person> people,SearchParameters parameters){

        int pageSize = parameters.getPage().getSize();
        int currentPage = parameters.getPage().getPageNumber();
        int from = pageSize * currentPage - pageSize;

        result.setPages(currentPage);
        result.setCurrentPage(currentPage);

        //to finish calculate last wanted index
        return people.subList(from, people.size()).stream().limit(pageSize).toList();
    }
}
