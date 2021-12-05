package org.example.queries.filters;

public class AgeFilter extends InclusiveRangeFilter {
    public AgeFilter(final int minimumAgeInclusive, final int maximumAgeInclusive) {
        super(minimumAgeInclusive, maximumAgeInclusive, "getAge");
    }
}
