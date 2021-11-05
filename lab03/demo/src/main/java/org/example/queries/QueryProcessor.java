package org.example.queries;

import org.example.criteria.*;
import org.example.functions.functionsArrayList;
import org.example.model.People;
import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {
    public List<Criteria> criteriaList = List.of(
            new AgeFromCriteria(),
            new AgeToCriteria(),
            new GenderCriteria(),
            new IncomeFromCriteria(),
            new IncomeToCriteria(),
            new NameCriteria(),
            new SurnameCriteria()

    );


    public Results GetResults(SearchParameters parameters){
        Results results = new Results();
        results.setItems(People.Data);
        criteriaList.forEach(criteria ->  criteria.criteriaUser(results,parameters));

        results.setPages(parameters.getPage() != null ? (int) Math.ceil((double) results.getItems().size() / parameters.getPage().getSize()) : parameters.getPage().getSize());
        results.setCurrentPage((parameters.getPage().getPageNumber()));
        List<Person> peopleList = new ArrayList<>();
        int sizeMultiplyActualPage = parameters.getPage().getSize()*parameters.getPage().getPageNumber();
        int minusSize = parameters.getPage().getSize();
        for (int i = sizeMultiplyActualPage - minusSize;i < sizeMultiplyActualPage; i++){
            if (i >= results.getItems().size() ) {
                break;
            }
            peopleList.add(results.getItems().get(i));
        }
        results.setItems(peopleList);

        functionsArrayList functionsArrayList = new functionsArrayList();
        functionsArrayList.functionsAddTo(parameters, results);


        return results;
    }
}
