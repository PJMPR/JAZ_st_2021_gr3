package org.example.queries.search;

public class Page {

    private int size;
    private int pageNumber;
    private int s2;
    private int s;

    public int getS2() {
        return s2;
    }

    public int getS() {
        return s;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public void setS(int s) {
        this.s = s;
    }

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
