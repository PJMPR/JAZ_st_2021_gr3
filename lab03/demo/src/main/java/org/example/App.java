package org.example;

import org.example.queries.QueryProcessor;
import org.example.queries.search.SearchParameters;

public class App {
    public static void main(String[] args){
        QueryProcessor queryProcessor = new QueryProcessor();
        queryProcessor.GetResults(new SearchParameters());
    }
}
