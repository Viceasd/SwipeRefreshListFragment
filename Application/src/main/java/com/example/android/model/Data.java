
package com.example.android.model;

import java.io.Serializable;
import java.util.List;


public class Data implements Serializable
{


    private List<Section> sections = null;

    private List<Item> items = null;

    private Pagination pagination;
    private final static long serialVersionUID = 9092773494888271566L;


    public List<Section> getSections() {
        return sections;
    }


    public void setSections(List<Section> sections) {
        this.sections = sections;
    }


    public List<Item> getItems() {
        return items;
    }


    public void setItems(List<Item> items) {
        this.items = items;
    }


    public Pagination getPagination() {
        return pagination;
    }


    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (!sections.equals(data.sections)) return false;
        if (!items.equals(data.items)) return false;
        return pagination.equals(data.pagination);

    }

    @Override
    public int hashCode() {
        int result = sections.hashCode();
        result = 31 * result + items.hashCode();
        result = 31 * result + pagination.hashCode();
        return result;
    }
}
