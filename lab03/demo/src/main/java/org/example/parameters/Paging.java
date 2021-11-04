package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class Paging extends Parameters {
    public static void paging(Results results, SearchParameters params) {
        if (params.getPage()!=null) {
            setCurrentPage(results, params);
            setPages(results, params);
            setItems(results, params);
        }
    }

    private static void setCurrentPage(Results results, SearchParameters params) {
        results.setCurrentPage(params.getPage().getPageNumber());
    }

    private static void setPages(Results results, SearchParameters params) {
        results.setPages((int)Math.ceil((double)results.getItems().size()/(double) params.getPage().getSize()));
    }

    private static void setItems(Results results, SearchParameters params) {
        results.setItems(getPersonsStream(results).skip(getCurrentSkip(results, params)).limit(params.getPage().getSize()).toList());
    }

    private static int getCurrentSkip(Results results, SearchParameters params) {
        return (results.getCurrentPage()-1)*params.getPage().getSize();
    }
}