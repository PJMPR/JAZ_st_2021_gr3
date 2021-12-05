package org.example.queries.filters;

public class SurnameFilter extends IgnoreCaseStringFilter {
    public SurnameFilter(final String surname) {
        super(surname, "getSurname");
    }
}
