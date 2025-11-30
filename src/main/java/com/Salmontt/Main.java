package com.Salmontt;

import com.Salmontt.data.GestorUnidades;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        GestorUnidades gestorUnidades = new GestorUnidades();
        gestorUnidades.cargarCentro("SalmontUnidadOperativa.xlsx");
        gestorUnidades.cargarPlanta("SalmontUnidadOperativa.xlsx");

        boolean salir = false;

        do{

            System.out.println("=========================================");
            System.out.println("|                                        |");
            System.out.println("|                 PORTAL                 |");
            System.out.println("|         SALMONTT PUERTO MONTT          |");
            System.out.println("|                                        |");
            System.out.println("=========================================");

            Scanner sc = new Scanner(System.in);

            System.out.println("\nPor favor escoga la lista que desea revisar:");
            System.out.println("1. Centro Cultivo");
            System.out.println("2. Planta Cultivo");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            String opcion = sc.nextLine().trim();

            switch(opcion){
                case "1":
                    gestorUnidades.listarCentro();

                    if (!bucleMenuVolver(sc)) {
                        salir = true;
                    }
                    break;
                case "2":

                    gestorUnidades.listarPlanta();

                    if (!bucleMenuVolver(sc)) {
                        salir = true;
                    }
                    break;

                case "3":
                    salir = true;
                    System.out.println("Saliendo del programa...");

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

