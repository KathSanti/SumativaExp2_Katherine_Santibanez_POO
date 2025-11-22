package com.Salmontt.data;

import com.Salmontt.model.Cliente;
import com.Salmontt.model.Proveedor;
import com.Salmontt.model.Trabajador;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorDatos {

    private List<Proveedor> listaP = new ArrayList();
    private List<Trabajador> listaT = new ArrayList();
    private List<Cliente> listaC = new ArrayList();


    public void CargarDatosProveedores(String ruta){
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(ruta);
            if (inputStream == null) {
                // Si no está en resources, intentar desde sistema de archivos
                inputStream = new FileInputStream(ruta);
            }

            XSSFWorkbook libro = new XSSFWorkbook(inputStream);
            XSSFSheet hoja = libro.getSheetAt(0);

            for (int i = 1; i <= hoja.getLastRowNum(); i++) {
                var fila = hoja.getRow(i);
                if (fila == null) continue;

                String rut = obtenerValorCelda(fila.getCell(0));
                String nombre = obtenerValorCelda(fila.getCell(1));
                String direccion = obtenerValorCelda(fila.getCell(2));
                String telefono = obtenerValorCelda(fila.getCell(3));
                String email = obtenerValorCelda(fila.getCell(4));
                String centroDeCosto = obtenerValorCelda(fila.getCell(5));

                Proveedor proveedor = new Proveedor(rut, nombre, telefono, direccion, email, centroDeCosto);
                agregarProveedor(proveedor);
            }

            libro.close();
            inputStream.close();


        } catch(Exception e) {
            System.out.println("Error al cargar proveedores: " + e.getMessage());
        }
    }

    public void CargarDatosCliente(String ruta){
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(ruta);
            if (inputStream == null) {
                inputStream = new FileInputStream(ruta);
            }

            XSSFWorkbook libro = new XSSFWorkbook(inputStream);
            XSSFSheet hoja = libro.getSheetAt(1);

            for (int i = 1; i <= hoja.getLastRowNum(); i++) {
                var fila = hoja.getRow(i);
                if (fila == null) continue;

                String rut = obtenerValorCelda(fila.getCell(0));
                String nombre = obtenerValorCelda(fila.getCell(1));
                String direccion = obtenerValorCelda(fila.getCell(2));
                String telefono = obtenerValorCelda(fila.getCell(3));
                String email = obtenerValorCelda(fila.getCell(4));
                String sucursal = obtenerValorCelda(fila.getCell(5));

                Cliente cliente = new Cliente(rut, nombre, telefono, direccion, email, sucursal);
                agregarCliente(cliente);
            }

            libro.close();
            inputStream.close();

        } catch(Exception e) {
            System.out.println("❌ Error al cargar clientes: " + e.getMessage());
        }
    }

    public void CargarDatosTrabajador(String ruta){
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(ruta);
            if (inputStream == null) {
                inputStream = new FileInputStream(ruta);
            }

            XSSFWorkbook libro = new XSSFWorkbook(inputStream);
            XSSFSheet hoja = libro.getSheetAt(2);

            for (int i = 1; i <= hoja.getLastRowNum(); i++) {
                var fila = hoja.getRow(i);
                if (fila == null) continue;

                String rut = obtenerValorCelda(fila.getCell(0));
                String nombre = obtenerValorCelda(fila.getCell(1));
                String apellidoPaterno = obtenerValorCelda(fila.getCell(2));
                String apellidoMaterno = obtenerValorCelda(fila.getCell(3));
                String direccion = obtenerValorCelda(fila.getCell(4));
                String telefono = obtenerValorCelda(fila.getCell(5));
                String email = obtenerValorCelda(fila.getCell(6));

                Trabajador trabajador = new Trabajador(rut, nombre, telefono, direccion, email,
                        apellidoPaterno, apellidoMaterno);
                agregarTrabajador(trabajador);
            }

            libro.close();
            inputStream.close();

        } catch(Exception e) {
            System.out.println("❌ Error al cargar trabajadores: " + e.getMessage());
            e.printStackTrace();
        }
    }


    // Metodo auxiliar para obtener valores de celdas de forma segura
    private String obtenerValorCelda(org.apache.poi.ss.usermodel.Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }


    //Metodos para agregar los datos del excel al programa

    public void agregarProveedor(Proveedor proveedor){
        listaP.add(proveedor);
    }

    public void agregarCliente(Cliente cliente){
        listaC.add(cliente);
    }

    public void agregarTrabajador(Trabajador trabajador){
        listaT.add(trabajador);
    }

    //Metodos para buscar  por criterio


    public List<Proveedor> buscarCentro(String centro) {
        List<Proveedor> resultadoCentro = new ArrayList<>();

        for (Proveedor proveedor : listaP) {
            if (proveedor.getCentroDeCosto().equals(centro)) {
                resultadoCentro.add(proveedor);
            }
        }

        // Mensaje informativo
        if (resultadoCentro.isEmpty()) {
            System.out.println("No se encontraron proveedores para el centro: " + centro);
        } else {
            System.out.println("Centro encontrado: " +  listaP);
        }

        return resultadoCentro;
    }


    public List<Cliente> buscarSucursal(String sucursal){
        List<Cliente> resultadoSucursal = new ArrayList<>();

        for(Cliente cliente : listaC){
            if(cliente.getSucursal().equals(sucursal)){
                resultadoSucursal.add(cliente);
            }
        }

        if (resultadoSucursal.isEmpty()) {
            System.out.println("No se encontraron Clientes para la sucursal: " + sucursal);
        }else {
            System.out.println("Sucursal encontrada: " +  listaC);
        }

        return resultadoSucursal;
    }


    public List<Trabajador> buscarRut(String rut) {
        List<Trabajador> resultadoRut = new ArrayList<>();

        // Validar formato básico del RUT
        if (rut == null || rut.trim().isEmpty()) {
            System.out.println("El RUT no puede estar vacío");
            return resultadoRut;
        }

        for (Trabajador trabajador : listaT) {
            if (trabajador.getRut().equalsIgnoreCase(rut.trim())) {
                resultadoRut.add(trabajador);
            }
        }

        return resultadoRut;
    }


    public void procesoBusquedaTrabajador() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese RUT a buscar: ");
        String rutBuscado = sc.nextLine().trim();

        List<Trabajador> resultados = buscarRut(rutBuscado);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron trabajadores con el RUT: " + rutBuscado);

            char confirma;
            do {
                System.out.print("¿Desea intentar con otro RUT? (S/N): ");
                confirma = sc.next().toUpperCase().charAt(0);
                sc.nextLine(); // Limpiar buffer

                if (confirma == 'S' || confirma != 's') {
                    // Lógica para nueva búsqueda
                    System.out.print("Ingrese nuevo RUT: ");
                    rutBuscado = sc.nextLine().trim();
                    resultados = buscarRut(rutBuscado);

                    if (!resultados.isEmpty()) {
                        System.out.println("RUT encontrado - " + resultados.size() + " trabajador(es):");
                        for (Trabajador t : resultados) {
                            System.out.println("- " + t.getNombre() + " | RUT: " + t.getRut());
                        }
                    }
                } else if (confirma == 'N' && confirma != 'n') {
                    System.out.println("Búsqueda finalizada.");
                    break;
                } else {
                    System.out.println("Opción no válida. Use S o N.");
                }
            } while (confirma == 'S' || confirma == 's');
        }

    }



    //Metodo para listar

    public void listarProveedores(){
        for(Proveedor proveedor : listaP){
            System.out.println("──────────────────────────────────");
            proveedor.procesarInformacionFicha();
            System.out.println("──────────────────────────────────");
        }
    }

    public void listarClientes(){
        for(Cliente clientes : listaC){
            System.out.println("──────────────────────────────────");
            clientes.procesarInformacionFicha();
            System.out.println("──────────────────────────────────");
        }
    }

    public void listarTrabajadores(){
        for(Trabajador trabajador : listaT){
            System.out.println("──────────────────────────────────");
            trabajador.procesarInformacionFicha();
            System.out.println("──────────────────────────────────");
        }
    }










}
