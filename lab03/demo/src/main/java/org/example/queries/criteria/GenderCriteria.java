package org.example.queries.criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Collectors;

public class GenderCriteria implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {

		if (parameters.getSelectedGenders() == null || parameters.getSelectedGenders().isEmpty()) {
			return persons;
		}


		return persons.stream()
				.filter(x -> parameters.getSelectedGenders().contains(x.getGender()))
				.collect(Collectors.toList());
	}
}
