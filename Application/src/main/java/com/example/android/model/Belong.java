
package com.example.android.model;

import java.io.Serializable;
import java.util.List;



public class Belong implements Serializable
{


    private String client;

    private List<String> accessGroup = null;

    private List<String> tournament = null;
    private final static long serialVersionUID = 2471184232179959364L;


    public String getClient() {
        return client;
    }


    public void setClient(String client) {
        this.client = client;
    }


    public List<String> getAccessGroup() {
        return accessGroup;
    }


    public void setAccessGroup(List<String> accessGroup) {
        this.accessGroup = accessGroup;
    }


    public List<String> getTournament() {
        return tournament;
    }


    public void setTournament(List<String> tournament) {
        this.tournament = tournament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Belong belong = (Belong) o;

        if (client != null ? !client.equals(belong.client) : belong.client != null) return false;
        if (accessGroup != null ? !accessGroup.equals(belong.accessGroup) : belong.accessGroup != null)
            return false;
        return tournament != null ? tournament.equals(belong.tournament) : belong.tournament == null;

    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (accessGroup != null ? accessGroup.hashCode() : 0);
        result = 31 * result + (tournament != null ? tournament.hashCode() : 0);
        return result;
    }
}
