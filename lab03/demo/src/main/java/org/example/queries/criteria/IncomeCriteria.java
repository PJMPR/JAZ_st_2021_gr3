package org.example.queries.criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Collectors;

public class IncomeCriteria implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {


		return persons.stream()
				.filter(x -> parameters.getIncomeFrom() == 0.0d || x.getIncome() >= parameters.getIncomeFrom())
				.filter(x -> parameters.getIncomeTo() == 0.0d || x.getIncome() <= parameters.getIncomeTo())
				.collect(Collectors.toList());
	}
}
