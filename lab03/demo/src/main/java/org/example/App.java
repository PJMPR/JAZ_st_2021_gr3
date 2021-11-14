package org.example;

import org.example.criteria.CriteriaAge;
import org.example.criteria.CriteriaGender;
import org.example.criteria.CriteriaGenderByFemale;
import org.example.criteria.CriteriaGenderByOther;
import org.example.model.Gender;
import org.example.model.People;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
        List<Person> personList = new ArrayList<>();
        personList.addAll(People.Data);
        SearchParameters parameters = new SearchParameters();
        CriteriaAge criteriaAge = new CriteriaAge();
        CriteriaGender male = new CriteriaGender();
        CriteriaGenderByFemale female = new CriteriaGenderByFemale();
        CriteriaGenderByOther other =new CriteriaGenderByOther();

        parameters.setAgeFrom(20);
        parameters.setAgeTo(30);
        System.out.println(other.meetCriteria(People.Data,parameters));
        //System.out.println(female.meetCriteria(People.Data,parameters));
        //System.out.println(male.meetCriteria(People.Data,parameters));

        //System.out.println(criteriaAge.meetCriteria(People.Data,parameters));
        /*System.out.println(personList.stream()
                .filter(person -> person.getName().equalsIgnoreCase(parameters.getName()))
                .toList());*/

    }
}
