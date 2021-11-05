package org.example.queries.search;

import org.example.queries.results.Results;

public class Page {

    private int size;
    private int pageNumber;

    public Page(int size, int pageNumber) {
        this.size = size;
        this.pageNumber = pageNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int calcElementsToSkip(Results results) {
        return (results.getCurrentPage() - 1) * size;
    }

    public int calcNeededPages(Results result) {
        if (size < result.getItems().size()) {
            if (result.getItems().size() % size != 0) {
                return result.getItems().size() / size + 1;
            } else {
                return result.getItems().size() / size;
            }
        }
        return 1;
    }
}
