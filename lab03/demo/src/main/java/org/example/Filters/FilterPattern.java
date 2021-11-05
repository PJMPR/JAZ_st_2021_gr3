package org.example.Filters;

import org.example.model.Person;
import org.example.queries.results.Results;

import java.util.List;

public  interface FilterPattern {
   void meetCriteria (Results results, String string);
}
