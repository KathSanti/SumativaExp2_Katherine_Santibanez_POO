package com.Salmontt.model;


public class Proveedor extends DatosFicha {

    private String CentroDeCosto;

    public String getCentroDeCosto() {
        return CentroDeCosto;
    }

    public void setCentroDeCosto(String centroDeCosto) {
        CentroDeCosto = centroDeCosto;
    }

    public Proveedor(String rut, String nombre, String telefono, String direccion, String email, String CentroDeCosto) {
        super(rut, nombre, telefono, direccion, email);
        this.CentroDeCosto=CentroDeCosto;
    }

    @Override
    public void procesarInformacionFicha(){
        System.out.println("Rut             : " + rut);
        System.out.println("Nombre          : " + nombre);
        System.out.println("Centro de costo : " + CentroDeCosto);
        System.out.println("Direccion       : " + direccion);
        System.out.println("Telefono        : " + telefono);
        System.out.println("Email           : " + email);
    }
}
