package org.example.queries;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleCriteria extends CriteriaBase{

    Predicate<SearchParameters> checkParams;
    CriteriaPredicate checkPerson;

    public SimpleCriteria(Predicate<SearchParameters> checkParams, CriteriaPredicate checkPerson){
        this.checkParams=checkParams;
        this.checkPerson = checkPerson;
    }

    @Override
    protected boolean canFilter() {
        return checkParams.test(parameters);
    }

    @Override
    protected boolean check(Person person) {
        return checkPerson.check(person, parameters);
    }
}
