package org.example.queries.filters;

import org.example.model.Gender;

import java.util.List;

public class GenderListFilter extends AnyFromListFilter {
    public GenderListFilter(final List<Gender> appropriateGenders) {
        super(appropriateGenders, "getGender");
    }
}
