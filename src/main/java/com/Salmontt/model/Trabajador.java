package com.Salmontt.model;


public class Trabajador extends DatosFicha {

    private String ApellidoPaterno;
    private String ApellidoMaterno;

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public Trabajador(String rut, String nombre, String telefono, String direccion, String email, String ApellidoPaterno, String ApellidoMaterno) {
        super(rut, nombre, telefono, direccion, email);
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
    }

    @Override
    public void procesarInformacionFicha() {
        System.out.println("Rut              : " + rut);
        System.out.println("Nombre           : " + nombre);
        System.out.println("Apellido Paterno : " + ApellidoPaterno);
        System.out.println("Apellido Materno : " + ApellidoMaterno);
        System.out.println("Direccion        : " + direccion);
        System.out.println("Telefono         : " + telefono);
        System.out.println("Email            : " + email);

    }


}
