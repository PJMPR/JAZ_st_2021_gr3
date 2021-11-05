package org.example.queries.Functions;

import org.example.queries.results.FunctionResult;

public class ListsFunctions {

    private final FunctionResult functionResult = new FunctionResult();
    private double sum = 0.0;
    private double average = 0.0;


    public FunctionResult getFunctionResult() {
        return functionResult;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
