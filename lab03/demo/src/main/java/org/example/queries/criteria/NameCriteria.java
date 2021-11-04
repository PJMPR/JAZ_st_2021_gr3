package org.example.queries.criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Collectors;

public class NameCriteria implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {

		if (parameters.getName() != null) {
			return persons.stream().filter(x -> x.getName().equalsIgnoreCase(parameters.getName())).collect(Collectors.toList());
		}

		return persons;
	}
}
