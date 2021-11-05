package org.example.queries.Operations;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.Page;

import java.util.List;

public class PageOperator {
    private Page page;

    public PageOperator(Page page) {
        this.page = page;
    }

    private List<Person> list(Results results) {
        if (!results.getItems().isEmpty()) {
            int toSkip = page.getSize() * (page.getPageNumber() - 1);
            return results.getItems().stream()
                    .skip(toSkip)
                    .limit(page.getSize())
                    .toList();
        }
        return results.getItems();
    }

    public void pageGetter(Results result) {
        if (page == null || page.getSize() > result.getItems().size()) {
            page = new Page(result.getItems().size(), 1);
        }
        result.setPages(calcPageSize(result));
        result.setCurrentPage(page.getPageNumber());
        result.setItems(list(result));

    }

    private int calcPageSize(Results result) {
        return result.getItems().size() / page.getSize();
    }
}
