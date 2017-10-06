
package com.example.android.model;

import java.io.Serializable;


public class Phase implements Serializable
{


    private String original;
    private final static long serialVersionUID = -4154076850925423260L;


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

        Phase phase = (Phase) o;

        return original != null ? original.equals(phase.original) : phase.original == null;

    }

    @Override
    public int hashCode() {
        return original != null ? original.hashCode() : 0;
    }
}
