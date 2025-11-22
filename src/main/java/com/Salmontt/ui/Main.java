package com.Salmontt.ui;

import com.Salmontt.data.GestorDatos;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        GestorDatos gestorDatos = new GestorDatos();
        gestorDatos.CargarDatosProveedores("SalmonttListas.xlsx");
        gestorDatos.CargarDatosCliente("SalmonttListas.xlsx");
        gestorDatos.CargarDatosTrabajador("SalmonttListas.xlsx");

        boolean salir = false;

        do{

            System.out.println("=========================================");
            System.out.println("|                                        |");
            System.out.println("|         PORTAL ADMINISTRATIVO          |");
            System.out.println("|         SALMONTT PUERTO MONTT          |");
            System.out.println("|                                        |");
            System.out.println("=========================================");

            Scanner sc = new Scanner(System.in);

            System.out.println("\nPor favor escoga la ficha administrativa que desea revisar:");
            System.out.println("1. Trabajadores");
            System.out.println("2. Proveedores");
            System.out.println("3. Clientes");
            System.out.print("Opción: ");
            String opcion = sc.nextLine().trim();

            switch(opcion){

                case "1":
                    System.out.println("\n╔════════════════════════════════╗");
                    System.out.println("║        LISTA TRABAJADORES      ║");
                    System.out.println("╚════════════════════════════════╝");

                    System.out.println("1) Mostrar listado de todos los trabajadores");
                    System.out.println("2) Buscar por rut");
                    System.out.println("Por favor ingrese una opción:");

                    String opcionDos = sc.nextLine().trim();

                    do{
                        switch (opcionDos) {
                            case "1":
                                gestorDatos.listarTrabajadores();

                                break;

                            case "2":

                                gestorDatos.procesoBusquedaTrabajador();
                                break;

                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                        }

                    }while(opcionDos != "1" && opcionDos !="2");





                    if (!bucleMenuVolver(sc)) {
                        salir = true;
                    }
                    break;

                case "2":

                    System.out.println("\n╔════════════════════════════════╗");
                    System.out.println("║        LISTA PROOVEDORES       ║");
                    System.out.println("╚════════════════════════════════╝");


                    System.out.println("1) Mostrar listado de todos los proveedores");
                    System.out.println("2) Buscar por centro de Costo");
                    System.out.println("Por favor ingrese una opción:");

                    String opcionTres = sc.nextLine().trim();

                    switch (opcionTres) {
                        case "1":
                            gestorDatos.listarProveedores();

                            break;

                        case "2":

                            System.out.println("Por favor escriba el centro de Costo:");
                            String centro = sc.nextLine();
                            gestorDatos.buscarCentro(centro);
                            break;

                        default:
                            System.out.println("Opción no válida. Intente nuevamente.");
                    }


                    if (!bucleMenuVolver(sc)) {
                        salir = true;
                    }
                    break;

                case "3":
                    System.out.println("\n╔════════════════════════════════╗");
                    System.out.println("║        LISTA CLIENTES          ║");
                    System.out.println("╚════════════════════════════════╝");

                    System.out.println("1) Mostrar listado de todos los clientes");
                    System.out.println("2) Buscar clientes por sucursal");
                    System.out.println("Por favor ingrese una opción:");



                    String opcionCuatro = sc.nextLine().trim();

                    switch (opcionCuatro) {
                        case "1":
                            gestorDatos.listarClientes();

                            break;

                        case "2":

                            System.out.println("Por favor escriba la sucural que desea buscar:");
                            String sucursal = sc.nextLine();
                            gestorDatos.buscarSucursal(sucursal);
                            break;

                        default:
                            System.out.println("Opción no válida. Intente nuevamente.");
                    }

                    if (!bucleMenuVolver(sc)) {
                        salir = true;
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");

            }


        }while(!salir);

    }

    public static boolean bucleMenuVolver(Scanner sc) {
        char confirma;

        System.out.print("¿Deseas volver al menú principal? (S/N): ");
        confirma = sc.next().charAt(0);
        sc.nextLine();

        while (confirma != 'S' && confirma != 's' && confirma != 'N' && confirma != 'n') {
            System.out.println("Opción no válida");
            System.out.print("Ingrese una opción válida (S/N): ");
            confirma = sc.next().charAt(0);
            sc.nextLine();
            System.out.println(" ");
        }

        if (confirma == 'N' || confirma == 'n') {
            System.out.println("Cerrando Software....");
            return false; // Mensaje de despedida al usuario
        }

        return true; // Volver al menú
    }
}