package com.pjwstk.sakila.diagnostics.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelfTestResult {
    private String name;
    private String description;
    private boolean passed;
    private List<String> errors;
}
