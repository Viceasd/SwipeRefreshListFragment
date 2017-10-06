
package com.example.android.model;

import java.io.Serializable;

public class Title implements Serializable
{

    private String original;
    private final static long serialVersionUID = 1037000188724522030L;

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

        Title title = (Title) o;

        return original != null ? original.equals(title.original) : title.original == null;

    }

    @Override
    public int hashCode() {
        return original != null ? original.hashCode() : 0;
    }
}
