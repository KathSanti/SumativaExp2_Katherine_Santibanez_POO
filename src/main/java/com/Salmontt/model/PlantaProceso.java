package com.Salmontt.model;

public class PlantaProceso extends UnidadOperativa {

    private int  capacidad;

    public PlantaProceso(String nombre, String comuna, int capacidad) {
        super(nombre, comuna);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Planta proceso       : " + nombre);
        System.out.println("Comuna               : " + comuna);
        System.out.println("Capacidad de proceso : " + capacidad);
    }


}
