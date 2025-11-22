package com.Salmontt.model;


public class Cliente extends DatosFicha {

    private String sucursal;

    public Cliente(String rut, String nombre, String telefono, String direccion, String email, String sucursal) {
        super(rut, nombre, telefono, direccion, email);
        this.sucursal = sucursal;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public void procesarInformacionFicha(){
        System.out.println("Rut       : " + rut);
        System.out.println("Nombre    : " + nombre);
        System.out.println("Sucursal  : " + sucursal);
        System.out.println("Direccion : " + direccion);
        System.out.println("Telefono  : " + telefono);
        System.out.println("Email     : " + email);
    }

}
