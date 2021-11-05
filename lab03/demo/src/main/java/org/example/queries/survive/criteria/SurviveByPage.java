package org.example.queries.survive.criteria;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.survive.SurviveHelper;
import org.example.queries.survive.SurvivorInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SurviveByPage implements SurvivorInterface {
    @Override
    public List<Person> doSelection(SearchParameters searchParameters, Results results) {
        SurviveHelper surviveHelper = new SurviveHelper(searchParameters, results);
        HashMap<Integer, List<Person>> pager = new HashMap<>();
        if(!surviveHelper.isSetPage()){
            int counter = 0;
            for(int i = 1 ; i <= surviveHelper.getPageNumber() ; i++){
                List<Person> people = new ArrayList<>();
                for(int j = 0 ; j < surviveHelper.getPageSize() ; j++){
                    if(j >= surviveHelper.getPersons().size()){
                        break;
                    } else{
                        people.add(results.getItems().get(counter));
                        counter++;
                    }
                }
                pager.put(i, people);
            }
        } else {
            return surviveHelper.getPersons();
        }
        return pager.get(surviveHelper.getPageNumber());
    }
}
