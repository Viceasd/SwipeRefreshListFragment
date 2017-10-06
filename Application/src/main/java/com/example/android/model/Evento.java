
package com.example.android.model;

import java.io.Serializable;


public class Evento implements Serializable
{

    private Data data;
    private final static long serialVersionUID = 49621680162818982L;


    public Data getData() {
        return data;
    }


    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evento evento = (Evento) o;

        return data != null ? data.equals(evento.data) : evento.data == null;

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
