# Actividad Semana 7 - Principios SOLID


## Descripción

Este código implementa un sistema de gestión para unidades operativas de una empresa acuícola, 
permitiendo cargar y visualizar información de centros de cultivo y plantas de proceso desde archivos Excel.Implementando fundamento SOLID.


## Estructura del Proyecto (Paquetes y clases)

    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── Salmontt/
    │   │   │           ├── MainApp.java           
    │   │   │           │
    │   │   │           ├── ui/                    
    │   │   │           │   ├── MenuConsola.java   
    │   │   │           │   ├── ValidadorSimple.java 
    │   │   │           │   ├── IMenu.java         # Interfaz del menú
    │   │   │           │   ├── IValidador.java    # Interfaz del validador
    │   │   │           │   └── Main.java          # Clase principal UI
    │   │   │           │
    │   │   │           ├── model/                 
    │   │   │           │   ├── UnidadOperativa.java
    │   │   │           │   ├── CentroCultivo.java
    │   │   │           │   └── PlantaProceso.java
    │   │   │           │
    │   │   │           └── data/                  
    │   │   │               ├── GestorUnidades.java
    │   │   │               └── ServicioPersistencia.java (opcional)
    │   │   │
    │   │   └── resources/
                        └── SalmontUnidadOperativa.xlsx    # Archivo de datos
       
  
## Aplicación de Interfaz 

En este proyecto se definieron interfaces que indicaron que debe hacer cada componente sin decir como lo debe hacer, 
lo anterior con la finalidad de que mis clases pudieran permiso o la licencia de hacer las acciones he imprimir por pantalla el menú 
y ejecutar el meto aplicando los principios SOLID.


    interface IValidador {
        boolean validarOpcion(String opcion);`
        boolean validarConfirmacion(char respuesta);
    }    interface IMenu {
            void mostrar();
            String obtenerOpcion(Scanner scanner);
        }
    
        // Interface para validador
        interface IValidador {
            boolean validarOpcion(String opcion);
            boolean validarConfirmacion(char respuesta);
        }`


## Resumen de la Organización SOLID:

| Paquete  | Responsabilidad  |  Principio SOLID |
| ------------ | ------------ | ------------ |
|  com.Salmontt | Punto de entrada  | SRP |
|  com.Salmontt.ui | Interfaz del usuario  | SRP, ISP, DIP  |
|  com.Salmontt.model | Modelar los datos  | LSP, OCP  |
|  com.Salmontt.data  | Acceder a dato  | SRP, DIP  |



## Funcionalidades Implementadas  

1. Herencia implentanda con "extends" y uso de super() en los contructores para inicializar atributos de mi super clase
2. Polimorfismo sobreescritura métodos
3. Jerarquía de clases para definir SuperCLase de SubClases
4. Iterface con principios de segregación
5. Principio de Sustitución de Liskov
6. Principio Abierto/Cerrado
7. Principio de responsabilidad única

