package org.example.queries.survive;

import org.example.model.Gender;
import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public record SurviveHelper(SearchParameters searchParameters, Results results) {

    public List<Person> getPersons() {
        return results.getItems();
    }

    public boolean ageIsBetween(Person person) {
        return (person.getAge() <= searchParameters.getAgeTo() && person.getAge() >= searchParameters.getAgeFrom());
    }

    public boolean genderAllowed(Person person) {
        for (Gender gender : searchParameters.getSelectedGenders()) {
            if (person.getGender().equals(gender))
                return true;
        }
        return false;
    }

    public boolean incomeIsBetween(Person person) {
        return (person.getIncome() <= searchParameters.getIncomeTo() && person.getIncome() >= searchParameters.getIncomeFrom());
    }

    public boolean isNamed(Person person) {
        return (person.getName().equals(searchParameters.getName()));
    }

    public boolean isSurname(Person person) {
        return (person.getSurname().equals(searchParameters.getSurname()));
    }

    public int getPageNumber(){
        return searchParameters.getPage().getPageNumber();
    }

    public int getPageSize(){
        return searchParameters.getPage().getSize();
    }
}
