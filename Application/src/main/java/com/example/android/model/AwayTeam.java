
package com.example.android.model;

import java.io.Serializable;



public class AwayTeam implements Serializable
{


    private String id;

    private String name;

    private String shortName;
    private final static long serialVersionUID = -3743117558975027896L;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getShortName() {
        return shortName;
    }


    public void setShortName(String shortName) {
        this.shortName = shortName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AwayTeam awayTeam = (AwayTeam) o;

        if (id != null ? !id.equals(awayTeam.id) : awayTeam.id != null) return false;
        if (name != null ? !name.equals(awayTeam.name) : awayTeam.name != null) return false;
        return shortName != null ? shortName.equals(awayTeam.shortName) : awayTeam.shortName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        return result;
    }
}
