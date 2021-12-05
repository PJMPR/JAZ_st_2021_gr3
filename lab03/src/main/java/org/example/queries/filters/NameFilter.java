package org.example.queries.filters;

public class NameFilter extends IgnoreCaseStringFilter {
    public NameFilter(final String name) {
        super(name, "getName");
    }
}
