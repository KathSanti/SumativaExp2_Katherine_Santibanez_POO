# 🐟 Portal Administrativo - Salmontt Puerto Montt
## Descripción

Sistema de gestión administrativa desarrollado en Java para la empresa Salmontt Puerto Montt. Permite administrar y consultar información de trabajadores, proveedores y clientes mediante una interfaz de consola intuitiva, cargando datos desde archivos Excel y proporcionando funcionalidades de búsqueda y listado.

## Estructura del Proyecto (Paquetes y clases)

    └─ SalmonttListas.xlsx    `com.Salmontt/
        ├── ui/
        │   └── Main.java          # Punto de entrada y menú principal
        ├── data/
        │   └── GestorDatos.java   # Gestión de datos y operaciones
        └── model/
        |    ├── DatosFicha.java    # Clase base abstracta
        |   ├── Trabajador.java    # Entidad Trabajador
        |    ├── Proveedor.java     # Entidad Proveedor
        |    └── Cliente.java       # Entidad Cliente
        ├── resuorces
            └─ SalmonttListas.xlsx

## Instrucciones para Ejecutar el Programa

- Java JDK 8 o superior
- Archivo SalmonttListas.xlsx en el directorio del proyecto
  
1. Compilar el proyecto:
   
       `javac -cp ".:lib/*" com/Salmontt/ui/Main.java`

2. Ejecutar la aplicación:

        java -cp ".:lib/*" com.Salmontt.ui.Main

## Navegación en el Sistema

    =========================================
    |         PORTAL ADMINISTRATIVO         |
    |         SALMONTT PUERTO MONTT         |
    =========================================
    
    Por favor escoga la ficha administrativa que desea revisar:
    1. Trabajadores
    2. Proveedores  
    3. Clientes
    Opción: 

para accder a las opciones debe escribir en su teclado los número entre el 1 - 3 y paara salir o volver en el sistema por favor confirme con los caracteres S/N

## Fuente de Datos

| Hoja  | Contenido  | Columnas |
| :------------ |:---------------:| :------------|
| 0      | Proveedores | RUT, Nombre, Dirección, Teléfono, Email, Centro de Costo |
| 1      | Clientes        |   RUT, Nombre, Dirección, Teléfono, Email, Sucursal |
| 2 | Trabajadores        |   RUT, Nombre, Apellido Paterno, Apellido Materno, Dirección, Teléfono, Email |
                
----
        
## Funcionalidades Implementadas   

1. Estructura basada en Colecciones 
2. Validación Básica de Datos Ingresados (entradas nulas, manejo tray - catch, Mensajes de error descriptivos)
3. Lectura de registros desde archivo xlsx con procesamiento de múltiples hojas 
4. Organización del Código en Paquetes Funcionales (ui/ - Interfaz de usuario y presentación, data/ - Gestión y acceso a dato, model/ - Entidades y modelo de dominio)


## Mejoras del sistema en Fase 2 
- Carga Dinámica: Datos cargados automáticamente al inicio
- Filtrado Avanzado: Búsquedas por RUT, Centro de Costo, Sucursal
- Recorrido Completo: Listado de todos los registros disponibles

# RESUMEN DE CONCEPTOS POO APLICADOS

|  Concepto | Implementación en el Código  |
| ------------ | ------------ |
| Herencia  | DatosFicha → Trabajador, Proveedor, Cliente  |
|  Polimorfismo | procesarInformacionFicha() con diferentes implementaciones  |
| Encapsulamiento  | Atributos privados + getters/setters  |
| Abstracción  | Clase abstracta con método abstracto  |
| Colecciones  | ArrayList<T> con generics  |
| Manejo de Excepciones  | Try-catch en carga de datos  |
