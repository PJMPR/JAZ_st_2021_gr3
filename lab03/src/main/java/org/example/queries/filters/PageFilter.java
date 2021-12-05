package org.example.queries.filters;

import org.example.model.Person;

import java.util.List;

public class PageFilter implements QueryFilter {
    private final int pageSize;
    private final int currentPage;

    public PageFilter(final int pageSize, final int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    @Override
    public List<Person> filter(final List<Person> people) {
        return people.stream().skip((long) pageSize * currentPage - pageSize).limit(pageSize).toList();
    }
}
