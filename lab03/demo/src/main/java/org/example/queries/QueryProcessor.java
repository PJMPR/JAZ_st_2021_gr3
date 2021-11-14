package org.example.queries;

import org.example.criteria.*;
import org.example.model.Gender;
import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.Page;
import org.example.queries.search.SearchParameters;

public class QueryProcessor {

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();
        CriteriaName named = new CriteriaName();
        CriteriaSurname surnamed = new CriteriaSurname();
        CriteriaAge aged = new CriteriaAge();
        CriteriaINcome byINcome = new CriteriaINcome();
        result.setItems(People.Data);

        result.setPages(parameters.getPage().getSize());
        result.setCurrentPage(parameters.getPage().getPageNumber());

        result.setItems(named.meetCriteria(People.Data,parameters));
        result.setItems(surnamed.meetCriteria(People.Data,parameters));
        result.setItems(aged.meetCriteria(People.Data,parameters));
        result.setItems(byINcome.meetCriteria(People.Data,parameters));
        if (parameters.getSelectedGenders().equals(Gender.MALE)){
            CriteriaGender male = new CriteriaGender();
            result.setItems(male.meetCriteria(People.Data,parameters));
        }
        if (parameters.getSelectedGenders().equals(Gender.FEMALE)){
            CriteriaGenderByFemale female = new CriteriaGenderByFemale();
            result.setItems(female.meetCriteria(People.Data,parameters));
        }
        if (parameters.getSelectedGenders().equals(Gender.OTHER)){
            CriteriaGenderByOther other = new CriteriaGenderByOther();
            result.setItems(other.meetCriteria(People.Data,parameters));
        }



        return result;
    }
}
