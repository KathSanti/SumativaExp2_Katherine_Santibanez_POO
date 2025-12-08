package com.Salmontt.model;

public abstract class UnidadOperativa {

    protected String nombre;
    protected String comuna;

    public UnidadOperativa(String nombre, String comuna) {
        this.nombre = nombre;
        this.comuna = comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getComuna() {
        return comuna;
    }



    public abstract void mostrarInformacion();



}
