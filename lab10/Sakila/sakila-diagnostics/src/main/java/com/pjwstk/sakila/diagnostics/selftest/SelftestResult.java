package com.pjwstk.sakila.diagnostics.selftest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelftestResult {

    private String name;
    private String description;
    private boolean passed;
    private List<String> errors;
}

