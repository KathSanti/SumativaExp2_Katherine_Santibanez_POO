package com.Salmontt.model;

public class CentroCultivo extends UnidadOperativa {

    private float toneladas;


    //Sobrecarga constructor

    public CentroCultivo(String nombre, String comuna, float toneladas) {
        super(nombre, comuna);
        this.toneladas = toneladas;
    }

    public float getToneladas() {
        return toneladas;
    }


    //Sobreescritura del metodo para mostrar información

    @Override
    public void mostrarInformacion() {
        System.out.println("Centro cultivo       : " + nombre);
        System.out.println("Comuna               : " + comuna);
        System.out.println("Toneladas producidas : " + toneladas);

    }

}
