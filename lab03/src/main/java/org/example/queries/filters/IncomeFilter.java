package org.example.queries.filters;

public class IncomeFilter extends InclusiveRangeFilter {
    public IncomeFilter(final double minimumIncomeInclusive, final double maximumIncomeInclusive) {
        super(minimumIncomeInclusive, maximumIncomeInclusive, "getIncome");
    }
}
