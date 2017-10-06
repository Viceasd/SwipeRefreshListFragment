
package com.example.android.model;

import java.io.Serializable;


public class Pagination implements Serializable
{


    private Integer page;

    private Integer first;

    private Integer items;

    private Integer last;

    private Integer next;

    private Integer pages;

    private Integer offset;

    private Integer totalItems;
    private final static long serialVersionUID = -4388102258045088731L;


    public Integer getPage() {
        return page;
    }


    public void setPage(Integer page) {
        this.page = page;
    }


    public Integer getFirst() {
        return first;
    }


    public void setFirst(Integer first) {
        this.first = first;
    }


    public Integer getItems() {
        return items;
    }


    public void setItems(Integer items) {
        this.items = items;
    }


    public Integer getLast() {
        return last;
    }


    public void setLast(Integer last) {
        this.last = last;
    }


    public Integer getNext() {
        return next;
    }


    public void setNext(Integer next) {
        this.next = next;
    }


    public Integer getPages() {
        return pages;
    }


    public void setPages(Integer pages) {
        this.pages = pages;
    }


    public Integer getOffset() {
        return offset;
    }


    public void setOffset(Integer offset) {
        this.offset = offset;
    }


    public Integer getTotalItems() {
        return totalItems;
    }


    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pagination that = (Pagination) o;

        if (page != null ? !page.equals(that.page) : that.page != null) return false;
        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        if (items != null ? !items.equals(that.items) : that.items != null) return false;
        if (last != null ? !last.equals(that.last) : that.last != null) return false;
        if (next != null ? !next.equals(that.next) : that.next != null) return false;
        if (pages != null ? !pages.equals(that.pages) : that.pages != null) return false;
        if (offset != null ? !offset.equals(that.offset) : that.offset != null) return false;
        return totalItems != null ? totalItems.equals(that.totalItems) : that.totalItems == null;

    }

    @Override
    public int hashCode() {
        int result = page != null ? page.hashCode() : 0;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (offset != null ? offset.hashCode() : 0);
        result = 31 * result + (totalItems != null ? totalItems.hashCode() : 0);
        return result;
    }
}
