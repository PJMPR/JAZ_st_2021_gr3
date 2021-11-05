package org.example.queries.Filters;
import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.Page;
import java.util.List;

public class PageFilter implements Filter {
    private Page page;
    Results results;


    public PageFilter(Page page,Results results) {
        this.page = page;
        this.results = results;
    }


    @Override
    public List<Person> filter(List<Person> persons) {
        if(!(page == null) && persons != null){
            int skipping = page.getSize() * (page.getPageNumber()-1);
            return persons.stream()
                    .skip(skipping)
                    .limit(page.getSize())
                    .toList();
        }
        return persons;
    }

    public Results setpageResoults(){
        if (page != null && results != null){
            results.setCurrentPage(page.getPageNumber());
            results.setPages(howManyPages(results));
            return results;
        }
        return results;
    }
    private int howManyPages (Results results){
        if (results.getItems().size() / page.getSize() == 0){
            return 1;
        }
        return results.getItems().size() / page.getSize();
    }

}