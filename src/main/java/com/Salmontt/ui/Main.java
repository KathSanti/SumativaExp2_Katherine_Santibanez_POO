package com.Salmontt.ui;

import com.Salmontt.data.GestorUnidades;

import java.util.Scanner;


    // Interface para menú
    interface IMenu {
        void mostrar();
        String obtenerOpcion(Scanner scanner);
    }

    // Interface para validador
    interface IValidador {
        boolean validarOpcion(String opcion);
        boolean validarConfirmacion(char respuesta);
    }

/**
 * Implementación de la interfaz IMenu para consola.
 * Aplicando el principio de inversión de dependencias (DIP) de SOLID.
 */

    class MenuConsola implements IMenu {
        @Override
        public void mostrar() {
            System.out.println("=========================================");
            System.out.println("|                 PORTAL                 |");
            System.out.println("|         SALMONTT PUERTO MONTT          |");
            System.out.println("=========================================\n");

            System.out.println("Por favor escoja la lista que desea revisar:");
            System.out.println("1. Centro Cultivo");
            System.out.println("2. Planta Cultivo");
            System.out.println("3. Salir");
        }

        @Override
        public String obtenerOpcion(Scanner scanner) {
            System.out.print("Opción: ");
            return scanner.nextLine().trim();
        }
    }

    // Implementación concreta de validador
    class ValidadorSimple implements IValidador {
        @Override
        public boolean validarOpcion(String opcion) {
            return opcion.equals("1") || opcion.equals("2") || opcion.equals("3");
        }

        @Override
        public boolean validarConfirmacion(char respuesta) {
            char upper = Character.toUpperCase(respuesta);
            return upper == 'S' || upper == 'N';
        }
    }

/**
 * Clase principal que inicia la aplicación del sistema de gestión de unidades.
 * Aplicando principios SOLID: Responsabilidad Única (SRP) y Open/Closed (OCP).
 *
 */



    // Clase Main
    public class Main {
    public static void main(String[] args) {
        // Crear dependencias
        Scanner scanner = new Scanner(System.in);
        IMenu menu = new MenuConsola();
        IValidador validador = new ValidadorSimple();
        GestorUnidades gestor = new GestorUnidades();

        // Inicializar datos
        gestor.cargarCentro("SalmontUnidadOperativa.xlsx");
        gestor.cargarPlanta("SalmontUnidadOperativa.xlsx");

        // Ejecutar aplicación
        boolean ejecutando = true;

        while (ejecutando) {
            // Mostrar menú
            menu.mostrar();

            // Obtener y validar opción
            String opcion;
            do {
                opcion = menu.obtenerOpcion(scanner);
                if (!validador.validarOpcion(opcion)) {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (!validador.validarOpcion(opcion));

            // Procesar opción
            ejecutando = procesarOpcion(opcion, gestor, scanner, validador);
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    /**
     * Procesa la opción seleccionada por el usuario.
     * Aplicando el principio de responsabilidad única (SRP).
     *
     * @param opcion    Opción seleccionada por el usuario
     * @param gestor    Gestor de unidades para operaciones de datos
     * @param scanner   Scanner para entrada del usuario
     * @param validador Validador para confirmaciones
     * @return true si debe continuar ejecutando, false para terminar
     */

    private static boolean procesarOpcion(String opcion, GestorUnidades gestor, Scanner scanner, IValidador validador) {
        // Switch mejorado (enhanced switch)
        return switch (opcion) {
            case "1" -> {
                gestor.listarCentro();
                yield preguntarContinuar(scanner, validador);
            }
            case "2" -> {
                gestor.listarPlanta();
                yield preguntarContinuar(scanner, validador);
            }
            case "3" -> {
                System.out.println("Saliendo del programa...");
                yield false; // Terminar ejecución
            }
            default -> true; // Continuar ejecución
        };
    }

    /**
     * Pregunta al usuario si desea volver al menú principal.
     * Incluye validación a la respuesta del usuario.
     *
     * @param scanner   Scanner para leer la respuesta
     * @param validador Validador para confirmar la respuesta
     * @return true si desea continuar, false si desea salir
     */

    private static boolean preguntarContinuar(Scanner scanner, IValidador validador) {
        char respuesta;
        do {
            System.out.print("¿Deseas volver al menú principal? (S/N): ");
            respuesta = scanner.next().charAt(0);
            scanner.nextLine(); // Limpiar buffer

            if (!validador.validarConfirmacion(respuesta)) {
                System.out.println("Respuesta inválida. Use S o N.");
            }
        } while (!validador.validarConfirmacion(respuesta));

        if (Character.toUpperCase(respuesta) == 'N') {
            System.out.println("Cerrando Software...");
            return false;
        }

        return true;
    }
}

