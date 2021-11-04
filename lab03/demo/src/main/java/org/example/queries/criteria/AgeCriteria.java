package org.example.queries.criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Collectors;

public class AgeCriteria implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {

		return persons.stream()
				.filter(x -> parameters.getAgeFrom() == 0 || x.getAge() >= parameters.getAgeFrom())
				.filter(x -> parameters.getAgeTo() == 0 || x.getAge() <= parameters.getAgeTo())
				.collect(Collectors.toList());
	}
}
