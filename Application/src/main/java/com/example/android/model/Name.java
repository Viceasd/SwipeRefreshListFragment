
package com.example.android.model;

import java.io.Serializable;


public class Name implements Serializable
{


    private String original;
    private final static long serialVersionUID = 2821624660216358828L;


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

        Name name = (Name) o;

        return original != null ? original.equals(name.original) : name.original == null;

    }

    @Override
    public int hashCode() {
        return original != null ? original.hashCode() : 0;
    }
}
