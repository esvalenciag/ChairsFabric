package interfaz;

import datos.CatalogoSillas;
import modelo.*;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        CatalogoSillas catalogo = new CatalogoSillas("sillas.txt");
        catalogo.readingData();

        Scanner sc = new Scanner(System.in);
        String opPrincipal = "";

        // Memu Principal
        do {
            System.out.println("\n------- FABRICA DE SILLAS -------");
            System.out.println("Para ver sillas por categoria, digite [c]");
            System.out.println("Para ver qué sillas salen del catálogo, digite [s]");
            System.out.println("Para terminar, digite [t]");
            System.out.print("¿Qué opción desea? ");
            opPrincipal = sc.nextLine().toLowerCase();

            switch (opPrincipal) {
                case "c":
                    mostrarSubmenuCategorias(sc, catalogo);
                    break;
                case "s":
                    mostrarEstatusRemocion(catalogo);
                    break;
                case "t":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("La opción elegida no es válida. Intente de nuevo.");
                    break;
            }
        } while (!opPrincipal.equals("t"));

        sc.close();
    }

    // Segundo menu si se toma la opcion s (Incluye Masajeadoras)
    private static void mostrarSubmenuCategorias(Scanner sc, CatalogoSillas catalogo) {
        String opCat = "";
        do {
            System.out.println("\n--- CATEGORÍAS DISPONIBLES ---");
            System.out.println("p: Presidenciales");
            System.out.println("g: Gerenciales");
            System.out.println("s: Secretariales");
            System.out.println("t: Tandem");
            System.out.println("r: De ruedas");
            System.out.println("m: Masajeadora");
            System.out.println("x: Volver al menú anterior");
            System.out.print("¿Qué opción desea? ");

            opCat = sc.nextLine().toLowerCase();

            // Usamos 'x' para volver y no confundir con 't' de Tandem
            if (opCat.equals("x")) {
                break;
            }

            boolean haySillas = false;
            for (Silla s : catalogo.getSillas()) {
                boolean pertenece = false;

                // Validación por tipo de objeto
                switch (opCat) {
                    case "p": if (s instanceof Presidencial) pertenece = true; break;
                    case "g": if (s instanceof Gerencial) pertenece = true; break;
                    case "s": if (s instanceof Secretarial) pertenece = true; break;
                    case "t": if (s instanceof Tandem) pertenece = true; break;
                    case "r": if (s instanceof SillaDeRuedas) pertenece = true; break;
                    case "m": if (s instanceof Masajeadora) pertenece = true; break;
                }

                if (pertenece) {
                    // DESPUÉS
                    System.out.println("Ref: " + s.getReferencia() + " | Precio: " + s.getPrecio() + " | Calificacion: " + s.getCalificacion() + " | " + s);
                    haySillas = true;
                }
            }

            // DESPUÉS
            if (!haySillas) {
                if ("pgstrm".contains(opCat)) {
                    System.out.println("No hay sillas de esta categoría en el catálogo.");
                } else {
                    System.out.println("Opción no válida.");
                }
            }

        } while (!opCat.equals("x"));
    }

    // mostrar que sillas se van a retirar 
    private static void mostrarEstatusRemocion(CatalogoSillas catalogo) {
        System.out.println("\n--- EVALUACIÓN DE CATÁLOGO (Referencia, Status) ---");
        for (Silla s : catalogo.getSillas()) {
            String status = "Mantener";

            if (s instanceof Removible) {
                status = ((Removible) s).removerDelCatalogo();
            }

            System.out.println(s.getReferencia() + ", " + status);
        }
    }
}