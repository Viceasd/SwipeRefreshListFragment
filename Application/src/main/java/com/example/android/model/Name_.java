
package com.example.android.model;

import java.io.Serializable;


public class Name_ implements Serializable
{


    private String es;

    private String original;
    private final static long serialVersionUID = 1817637070392193451L;


    public String getEs() {
        return es;
    }


    public void setEs(String es) {
        this.es = es;
    }


    public String getOriginal() {
        return original;
    }


    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name_ name_ = (Name_) o;

        if (es != null ? !es.equals(name_.es) : name_.es != null) return false;
        return original != null ? original.equals(name_.original) : name_.original == null;

    }

    @Override
    public int hashCode() {
        int result = es != null ? es.hashCode() : 0;
        result = 31 * result + (original != null ? original.hashCode() : 0);
        return result;
    }
}
