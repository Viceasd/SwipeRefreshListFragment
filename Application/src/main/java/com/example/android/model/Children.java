
package com.example.android.model;

import java.io.Serializable;
import java.util.List;


public class Children implements Serializable
{


    private List<String> timeLine = null;

    private List<String> formation = null;
    private final static long serialVersionUID = 3031115850687386431L;


    public List<String> getTimeLine() {
        return timeLine;
    }


    public void setTimeLine(List<String> timeLine) {
        this.timeLine = timeLine;
    }


    public List<String> getFormation() {
        return formation;
    }


    public void setFormation(List<String> formation) {
        this.formation = formation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Children children = (Children) o;

        if (timeLine != null ? !timeLine.equals(children.timeLine) : children.timeLine != null)
            return false;
        return formation != null ? formation.equals(children.formation) : children.formation == null;

    }

    @Override
    public int hashCode() {
        int result = timeLine != null ? timeLine.hashCode() : 0;
        result = 31 * result + (formation != null ? formation.hashCode() : 0);
        return result;
    }
}
