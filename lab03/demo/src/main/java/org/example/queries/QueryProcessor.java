package org.example.queries;

import org.example.model.People;
import org.example.model.Person;
import org.example.queries.criteria.AgeCriteria;
import org.example.queries.criteria.Criteria;
import org.example.queries.criteria.GenderCriteria;
import org.example.queries.criteria.IncomeCriteria;
import org.example.queries.criteria.NameCriteria;
import org.example.queries.results.FunctionProcessor;
import org.example.queries.results.PageResult;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.Arrays;
import java.util.List;

public class QueryProcessor {

    List<Criteria> criteriaList = Arrays.asList(new AgeCriteria(), new NameCriteria(), new IncomeCriteria(),new GenderCriteria());

    public Results getResults(SearchParameters parameters) {
        Results results = new Results();

        List<Person> persons = People.Data;

        for (Criteria criteria : criteriaList) {
            persons = criteria.meetCriteria(persons, parameters);
        }
        results.setItems(persons);

        FunctionProcessor functionProcessor = new FunctionProcessor(results);
        functionProcessor.calculate(parameters.getFunctions());

        PageResult pageResult = new PageResult(results);
        pageResult.pageResult(parameters.getPage());

        return results;
    }
}
