# 🪑 Sistema de Gestión: Fábrica de Sillas

Sistema de administración de inventario desarrollado en Java que procesa catálogos de productos desde un archivo de texto plano y evalúa la permanencia de las sillas utilizando reglas de negocio basadas en: **Precio**, **Calificación** y **Categoría** mediante programación orientada a objetos.

---

## 📋 Tabla de Contenidos

- [Descripción](#-descripción)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Requisitos](#-requisitos)
- [Compilación](#-compilación)
- [Uso](#-uso)
- [Formato del Archivo de Entrada](#-formato-del-archivo-de-entrada)
- [Reglas de Negocio (Remoción)](#-reglas-de-negocio-remoción)
- [Reporte de Errores y Deficiencias](#-reporte-de-errores-y-deficiencias)
- [Ejemplo Completo](#-ejemplo-completo)
- [Diseño y Arquitectura](#-diseño-y-arquitectura)

---

## 📌 Descripción

El sistema lee un archivo `.txt` con los datos de las sillas fabricadas. A partir de ese archivo, el programa:

1. Determina dinámicamente el tipo de silla y sus atributos específicos.
2. Valida y limpia cada línea de datos individualmente.
3. Clasifica las sillas por categorías mediante un menú interactivo.
4. Aplica las reglas de negocio para imprimir un reporte de qué sillas se deben **Remover** o **Mantener** en el catálogo.

---

## 🗂️ Estructura del Proyecto

```text
ChairsFabric/
├── modelo/
│   ├── Silla.java            # Clase abstracta base con atributos comunes
│   ├── Removible.java        # Interfaz que define el contrato de evaluación
│   ├── Presidencial.java     # Entidad con lógica de importación
│   ├── Gerencial.java        # Entidad con restricciones de costo máximo
│   ├── Secretarial.java      # Entidad con filtros de calificación mínima
│   ├── Tandem.java           # Entidad de expansión (sillas de espera)
│   ├── SillaDeRuedas.java    # Entidad de expansión (salud y movilidad)
│   └── Masajeadora.java      # Entidad de expansión (alto confort)
├── datos/
│   └── CatalogoSillas.java   # Lógica de persistencia: lee y parsea el archivo plano
└── interfaz/
    └── Runner.java           # Orquestador: gestiona menús e imprime resultados
```

---

## ✅ Requisitos

- **Java 8** o superior
- No requiere librerías ni dependencias externas

---

## 🔧 Compilación

Desde la raíz del proyecto, ejecuta:

```bash
javac -d out modelo/*.java datos/*.java interfaz/*.java
```

Esto compilará todas las clases y depositará los `.class` en el directorio `out/`.

---

## ▶️ Uso

```bash
# Ejecución desde la carpeta raíz
java -cp out interfaz.Runner
```

> **Importante:** Asegúrate de que el archivo `sillas.txt` se encuentre en el directorio raíz del proyecto (al mismo nivel que la carpeta `src` o `out`).

### Opciones del Menú Principal

| Comando | Descripción |
|---------|-------------|
| `c` | Abre el submenú para filtrar e imprimir sillas por categoría específica |
| `s` | Ejecuta la evaluación del catálogo (reporte de remoción) |
| `t` | Finaliza la ejecución del programa |

---

## 📄 Formato del Archivo de Entrada

El archivo de entrada debe seguir estrictamente el formato de Valores Separados por Comas:

- **Columnas Base:** `Referencia, Categoría, Precio, Calificación`
- **Columnas Extra:** Varían dependiendo del tipo de silla (ej. `esImportada`, `puestos`, `traccion`,`calefaccion`).

### Ejemplo de archivo válido (`sillas.txt`)

```text
Monk, Gerencial, 310000, 4.8
Zart, Presidencial, 400000, 3.5, si
Delphi, Secretarial, 185000, 2.8
S004, tándem, 600000, 4.0, 3
M001, masajeadora, 1200000, 4.5, 5, si
```

> **Nota:** Las líneas vacías son ignoradas automáticamente y los espacios en blanco alrededor de las comas se limpian durante la lectura.

---

## 📊 Reglas de Negocio (Remoción)

### Sillas Tradicionales (Implementan `Removible`)

Cada silla tradicional pasa por un filtro de calidad y costo. Si no cumple el estándar, es marcada para remoción:

| Categoría | Condición para ser **Removida**                                      |
|-----------|----------------------------------------------------------------------|
| **Gerencial** | Calificacion < 4.0 **Y** Precio > $300,000                           |
| **Secretarial** | Calificación < 3.0 **Y** Precio > $200.000                           |
| **Presidencial** | Es importada ("si") **Y** Calificacion < 3.5 **O** Precio > $400.000 |

### Sillas de Expansión (Tandem, De Ruedas, Masajeadora)

Las nuevas categorías no están sujetas a evaluación estricta en esta versión del software.
> **Comportamiento:** Siempre devuelven el estado `Mantener`.

---

## 🚫 Reporte de Errores y Deficiencias

Durante el desarrollo y pruebas se identificaron y documentaron los siguientes elementos:

- **Conflicto de Diseño en Menús:** El diseño original requería la letra `t` tanto para filtrar sillas "Tandem" como para "Terminar". Se mitigó implementando la tecla `x` para retroceder.
- **Sensibilidad de Tipado:** El conversor `Float.parseFloat()` fallaba con los espacios contiguos en el archivo de texto. Se solventó aplicando `.trim()` a cada segmento del arreglo de datos.
- **Limitación de Persistencia:** El sistema actualiza el estado de las sillas en memoria, pero la salida no se sobreescribe en disco ni se exporta a un nuevo archivo.

---

## 💡 Ejemplo Completo

### Archivo de entrada (`sillas.txt`)

```text
Monk, Gerencial, 310000, 4.8
Zart, Presidencial, 400000, 3.5, si
Delphi, Secretarial, 185000, 2.8
```

### Ejecución de opción `s` (Evaluación de Catálogo)

**Salida esperada en consola:**

```text
------- FABRICA DE SILLAS -------
Para ver sillas por categoria, digite c
Para ver qué sillas salen del catálogo, digite s
Para terminar, digite t
¿Qué opción desea? s

--- EVALUACIÓN DE CATÁLOGO (Referencia, Status) ---
Monk, Remover
Zart, Mantener
Delphi, Remover
```

---

## 🏗️ Diseño y Arquitectura

El proyecto aplica principios de **separación de responsabilidades** y **orientación a objetos** avanzada:

- **`Silla`** — Clase abstracta pura que centraliza los atributos compartidos (referencia, precio, calificación) e impide instanciación sin tipo.
- **`Removible`** — Interfaz que define el contrato de auditoría. Permite aplicar el Principio de Segregación de Interfaces (ISP).
- **`CatalogoSillas`** — Encapsula la lógica de I/O (lectura de disco), validación de líneas y uso de bloque `switch` para la instanciación polimórfica.
- **`Runner`** — Punto de entrada minimalista que orquesta la interacción del usuario delegando la carga al catálogo.
