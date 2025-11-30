package com.Salmontt.model;

public class  CentroCultivo extends UnidadOperativa  {

    private float toneladasProduccion;

    public CentroCultivo(String nombre, String comuna,float toneladasProduccion) {
        super(nombre, comuna);
        this.toneladasProduccion = toneladasProduccion;
    }

    public float getToneladasProduccion() {
        return toneladasProduccion;
    }

    public void setToneladasProduccion(float toneladasProduccion) {
        this.toneladasProduccion = toneladasProduccion;
    }

    @Override
    public String toString() {
        return
                "Nombre: " + getNombre() +
                "\nComuna: " + getComuna() +
                "\nToneladas Produccion : " + toneladasProduccion;
    }
}
