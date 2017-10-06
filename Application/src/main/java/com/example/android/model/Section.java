
package com.example.android.model;

import java.io.Serializable;

public class Section implements Serializable
{


    private Integer index;

    private String id;

    private Title title;
    private final static long serialVersionUID = 7185147829754937763L;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Title getTitle() {
        return title;
    }


    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        if (index != null ? !index.equals(section.index) : section.index != null) return false;
        if (id != null ? !id.equals(section.id) : section.id != null) return false;
        return title != null ? title.equals(section.title) : section.title == null;

    }

    @Override
    public int hashCode() {
        int result = index != null ? index.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
