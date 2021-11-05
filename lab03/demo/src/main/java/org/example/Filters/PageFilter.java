package org.example.Filters;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.Page;

import java.util.stream.Collectors;

public class PageFilter extends Results {


    public Results meetCriteria(Results results, Page page) {
        int howManyPeopleToSkip = page.getSize() * (page.getPageNumber() - 1);
        int limit = page.getSize();
        int howmannyPages = roundUp(results.getItems().stream().count(),page.getSize());

         results.setItems(results.getItems().stream().skip(howManyPeopleToSkip).limit(limit).collect(Collectors.toList()));

         results.setPages(howmannyPages);
         results.setCurrentPage(page.getPageNumber());
        return results;
    }

    private int roundUp(long count, int size) {
        int pagesamount =0;
        if(count % size != 0){
            pagesamount = (int) count/size + 1;
        }else {
            pagesamount= (int) count/size;
        }
        return pagesamount;
    }
}
