
package com.example.android.model;

import java.io.Serializable;


public class EventStatus implements Serializable
{


    private String id;

    private Name_ name;

    private String category;
    private final static long serialVersionUID = 8373792353535836371L;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public Name_ getName() {
        return name;
    }


    public void setName(Name_ name) {
        this.name = name;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventStatus that = (EventStatus) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return category != null ? category.equals(that.category) : that.category == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
