package com.Salmontt.data;

import com.Salmontt.model.CentroCultivo;
import com.Salmontt.model.PlantaProceso;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorUnidades {

    private List<CentroCultivo> ListaCentro = new ArrayList<>();
    private List<PlantaProceso> ListaPlanta = new ArrayList<>();

    public void cargarCentro(String ruta) {
        try{
            InputStream input = getClass().getClassLoader().getResourceAsStream(ruta);
            XSSFWorkbook excel = new XSSFWorkbook(input);
            XSSFSheet hoja = excel.getSheetAt(0);

            for(int i = 1; i <= hoja.getLastRowNum(); i++){
                var fila = hoja.getRow(i);
                if(fila == null){ continue; }

                // Leer datos de cada columna en la misma fila
                String nombre = fila.getCell(0).getStringCellValue();
                String comuna = fila.getCell(1).getStringCellValue();
                int toneladasProduccion = (int) fila.getCell(2).getNumericCellValue();

                CentroCultivo centroCultivo = new CentroCultivo(nombre, comuna, toneladasProduccion);
                ListaCentro.add(centroCultivo);
            }

            excel.close();

        } catch(Exception e){
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cargarPlanta(String ruta) {
        try{

            InputStream input = getClass().getClassLoader().getResourceAsStream(ruta);
            XSSFWorkbook excel = new XSSFWorkbook(input);
            XSSFSheet hoja = excel.getSheetAt(1);

            for(int i = 1; i <= hoja.getLastRowNum(); i++){
                var fila = hoja.getRow(i);
                if(fila == null){ continue; }

                String nombre = fila.getCell(0).getStringCellValue();
                String comuna = fila.getCell(1).getStringCellValue();
                int CapacidadProduccion = (int) fila.getCell(2).getNumericCellValue();


                PlantaProceso plantaProceso = new  PlantaProceso(nombre, comuna, CapacidadProduccion);
                ListaPlanta.add(plantaProceso);
            }





        }catch(Exception e){
            System.out.println("Error al cargar el archivo");
            e.printStackTrace();
        }
    }

    public void listarCentro(){
        for(CentroCultivo centroCultivo : ListaCentro){
            System.out.println("──────────────────────────────────");
            System.out.println(centroCultivo.toString());
            System.out.println("──────────────────────────────────");

        }
    }

    public void listarPlanta(){
        for( PlantaProceso plantaProceso : ListaPlanta){
            System.out.println("──────────────────────────────────");
            System.out.println(plantaProceso.toString());
            System.out.println("──────────────────────────────────");
        }

    }


}
