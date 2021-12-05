package org.example.queries.filters;


public abstract class IgnoreCaseStringFilter extends EqualityFilter {
    public IgnoreCaseStringFilter(final String expected, final String getter) {
        super(expected, getter);
    }

    @Override
    protected boolean equals(final Object expected, final Object given) {
        
        final String s1 = (String) expected;
        final String s2 = (String) given;
        
        return s1.equalsIgnoreCase(s2);
    }
}
