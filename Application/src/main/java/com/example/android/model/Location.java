
package com.example.android.model;

import java.io.Serializable;

public class Location implements Serializable
{


    private String original;
    private final static long serialVersionUID = 3616395820127592956L;

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

        Location location = (Location) o;

        return original != null ? original.equals(location.original) : location.original == null;

    }

    @Override
    public int hashCode() {
        return original != null ? original.hashCode() : 0;
    }
}
