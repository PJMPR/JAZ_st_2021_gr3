package org.example.queries.search;

public class Page {

    // Defined how page work
    // Page have size
    // And number
    // For each page can exist only "size" records

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
}
