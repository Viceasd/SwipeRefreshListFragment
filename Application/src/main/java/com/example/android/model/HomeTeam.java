
package com.example.android.model;

import java.io.Serializable;



public class HomeTeam implements Serializable
{


    private String id;

    private String name;

    private String shortName;
    private final static long serialVersionUID = 791760315716955505L;


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

        HomeTeam homeTeam = (HomeTeam) o;

        if (id != null ? !id.equals(homeTeam.id) : homeTeam.id != null) return false;
        if (name != null ? !name.equals(homeTeam.name) : homeTeam.name != null) return false;
        return shortName != null ? shortName.equals(homeTeam.shortName) : homeTeam.shortName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        return result;
    }
}
