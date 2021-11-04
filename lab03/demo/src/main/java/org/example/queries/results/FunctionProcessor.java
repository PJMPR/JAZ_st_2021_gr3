package org.example.queries.results;

import org.example.model.Person;
import org.example.queries.search.FunctionsParameters;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FunctionProcessor {

	private final Results results;

	public FunctionProcessor(Results results) {
		this.results = results;
	}

	public void calculate(List<FunctionsParameters> functions) {
		List<FunctionResult> functionResults = new ArrayList<>();

		for (FunctionsParameters function : functions) {
			double result = 0;


			switch (function.getFunction()) {
				case AVARAGE:
					result = getAvarage(function.getFieldName());
					break;
				case SUM:
					result = getSum(function.getFieldName());
					break;
				default:
					throw new UnsupportedOperationException("Brak obslugi funkcji [" + function.getFunction() + "]");
			}

			FunctionResult functionResult = new FunctionResult();
			functionResult.setFieldName(function.getFieldName());
			functionResult.setFunction(function.getFunction());
			functionResult.setValue(result);

			functionResults.add(functionResult);
		}

		results.setFunctionResults(functionResults);
	}

	private double getSum(String fieldName) {
		double sum = 0;

		try {
			Field personField = Person.class.getDeclaredField(fieldName);
			personField.setAccessible(true);

			for (Person person : results.getItems()) {
				sum = sum + ((Number) personField.get(person)).doubleValue();
			}

		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
			new RuntimeException(e);
		}

		return sum;
	}

	private double getAvarage(String fieldName) {
		return getSum(fieldName) / results.getItems().size();
	}
}
