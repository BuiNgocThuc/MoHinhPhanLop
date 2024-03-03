package util;

import java.util.List;

public class Paginate<T> {

    private int offset;
    private int totalItems;
    private int currentPage;
    private int totalPages;
    private List<T> items;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Paginate() {
    }

    public Paginate(int offset, int totalItems, int currentPage, int totalPages, List<T> items) {
        this.offset = offset;
        this.totalItems = totalItems;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Paginate{" + "offset=" + offset + ", totalItems=" + totalItems + ", currentPage=" + currentPage + ", totalPages=" + totalPages + ", items=" + items + '}';
    }

}
