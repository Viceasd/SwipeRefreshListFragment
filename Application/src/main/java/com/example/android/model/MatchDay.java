
package com.example.android.model;

import java.io.Serializable;


public class MatchDay implements Serializable
{


    private String start;

    private String end;

    private Name name;

    private Phase phase;
    private final static long serialVersionUID = -5462013466254243392L;


    public String getStart() {
        return start;
    }


    public void setStart(String start) {
        this.start = start;
    }


    public String getEnd() {
        return end;
    }


    public void setEnd(String end) {
        this.end = end;
    }


    public Name getName() {
        return name;
    }


    public void setName(Name name) {
        this.name = name;
    }


    public Phase getPhase() {
        return phase;
    }


    public void setPhase(Phase phase) {
        this.phase = phase;
    }




}
