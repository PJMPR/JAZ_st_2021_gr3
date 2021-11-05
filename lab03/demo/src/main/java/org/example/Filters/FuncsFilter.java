package org.example.Filters;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncsFilter {
    private final List<FunctionResult> functionResultList = new ArrayList<>();


    public Results meetCriteria(Results results, List<FunctionsParameters> list) {

        if (has_Field_With_Name_Age(list)) {
            // We do not want  fields with income to be here, gonna filtr it
            List<FunctionsParameters> only_age_Parameters = list.stream().
                        filter(functionsParameters -> functionsParameters.getFieldName()
                                .equalsIgnoreCase("age")).collect(Collectors.toList());

            if (has_Func_Sum(only_age_Parameters)) {
                int value = results.getItems().stream().mapToInt(Person::getAge).sum();

                functionResultList.add(new FunctionResult(Funcs.SUM, "AGE", value));
            }
            if (has_Func_AVG(only_age_Parameters)) {
                double sum = results.getItems().stream().mapToDouble(Person::getAge).sum();
                double value = (sum / results.getItems().stream().count());

                functionResultList.add(new FunctionResult(Funcs.AVARAGE, "AGE", value));

            }
        }

        if (has_Field_With_Name_Income(list)) {
            // We do not want  fields with age to be here, gonna filtr it
            List<FunctionsParameters> only_Income_Parameters = list.stream().
                    filter(functionsParameters -> functionsParameters.getFieldName()
                            .equalsIgnoreCase("Income")).collect(Collectors.toList());
            if (has_Func_Sum(only_Income_Parameters)) {

                double value = results.getItems().stream().mapToDouble(Person::getIncome).sum();

                functionResultList.add(new FunctionResult(Funcs.SUM, "INCOME", value));

            }
            if (has_Func_AVG(only_Income_Parameters)) {
                double sum = results.getItems().stream().mapToDouble(Person::getIncome).sum();
                double value = (sum / results.getItems().stream().count());

                functionResultList.add(new FunctionResult(Funcs.AVARAGE, "INCOME", value));

            }
        }

        results.setFunctionResults(functionResultList);

        return results;
    }



    boolean has_Field_With_Name_Age(List<FunctionsParameters> list){
        boolean isok = true;
        if(! list.stream().anyMatch(functionsParameters -> functionsParameters.getFieldName().equalsIgnoreCase("age"))){
            isok = false;
        }
        return isok;
    }

    boolean has_Field_With_Name_Income(List<FunctionsParameters> list){
        boolean isok = true;
        if(! list.stream().anyMatch(functionsParameters -> functionsParameters.getFieldName().equalsIgnoreCase("income"))){
            isok = false;
        }
        return isok;
    }
    boolean has_Func_Sum(List<FunctionsParameters> list){
        boolean isok = true;
        if(! list.stream().anyMatch(functionsParameters -> functionsParameters.getFunction().equals(Funcs.SUM))){
            isok = false;
        }
        return isok;
    }
    boolean has_Func_AVG(List<FunctionsParameters> list){
        boolean isok = true;
        if(! list.stream().anyMatch(functionsParameters -> functionsParameters.getFunction().equals(Funcs.AVARAGE))){
            isok = false;
        }
        return isok;
    }
}
