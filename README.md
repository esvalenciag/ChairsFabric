# Fábrica de Sillas - Sistema de Gestión de Catálogo

Este proyecto es una aplicación en Java diseñada para gestionar el catálogo de una fábrica de sillas. Permite cargar datos desde un archivo de texto, clasificar sillas por categorías y evaluar cuáles deben ser removidas del catálogo basándose en reglas de negocio específicas (precio y calificación).

## 1. Estructura del Proyecto

El sistema está dividido en los siguientes paquetes:
- **`modelo`**: Contiene la clase abstracta `Silla`, la interfaz `Removible` y las subclases (`Presidencial`, `Gerencial`, `Secretarial`, `Tandem`, `SillaDeRuedas`, `Masajeadora`).
- **`datos`**: Contiene la clase `CatalogoSillas` encargada de la lectura del archivo `sillas.txt`.
- **`presentacion`**: Contiene la clase `Runner` con la lógica de los menús e interacción con el usuario.

## 2. Instrucciones de Ejecución

1.  **Preparar el archivo de datos**: Asegúrese de que el archivo `sillas.txt` esté ubicado en la **raíz del proyecto** (fuera de la carpeta `src`).
2.  **Formato del archivo**: El archivo debe contener líneas separadas por comas. Ejemplo:
    `Monk, Gerencial, 310000, 4.8`
3.  **Compilar y Ejecutar**: Ejecute la clase `Runner.java` desde su IDE (IntelliJ IDEA recomendado).

## 3. Reporte de Errores, Deficiencias y Faltantes

### A. Deficiencias de Diseño (Enunciado del Taller)
- **Conflicto de Atajos de Teclado**: El requerimiento original del taller asignaba la letra **'t'** tanto para la categoría "Tandem" como para la opción "Terminar" en el submenú.
    - *Solución implementada*: Se modificó el atajo de salida a **'x'** o se priorizó el retorno al menú principal para evitar cierres accidentales.
- **Ambigüedad en Remoción**: El diseño no especifica si las sillas nuevas (`Tandem`, `SillaDeRuedas`, `Masajeadora`) deben implementar la interfaz `Removible`.
    - *Decisión tomada*: Se mantuvieron como no removibles por defecto ("Mantener") para seguir estrictamente la jerarquía del diagrama original.

### B. Deficiencias de Implementación
- **Sensibilidad a Espacios**: Inicialmente, los espacios después de las comas en el archivo `.txt` causaban errores de conversión en `Float.parseFloat`.
    - *Corrección*: Se aplicó `.trim()` a cada dato leído en `CatalogoSillas`.
- **Manejo de Tildes**: La categoría "tándem" en el código fuente puede fallar si la codificación del archivo de texto no es UTF-8. Se recomienda usar nombres sin tildes para mayor compatibilidad.

### C. Faltantes
- **Persistencia de Cambios**: El sistema evalúa qué sillas deben removerse pero no modifica el archivo original ni guarda un nuevo reporte en disco.
- **Validación Robusta**: Aunque se capturan excepciones generales, el sistema podría fallar si el archivo tiene líneas con columnas incompletas.

## 4. Requerimientos Cumplidos
- [x] Lectura dinámica de archivo plano.
- [x] Implementación de Herencia y Polimorfismo.
- [x] Uso de Interfaces para lógica de negocio.
- [x] Menús anidados con validación de opciones.
- [x] Clasificación de sillas por tipo (`instanceof`).

## 5. Autor
- **Estudiante**: Esteban Valencia Gonzales y Juan Jose Atehortua Vallejo
- **Asignatura**: Programación Orientada a Objetos