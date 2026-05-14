package datos;

import modelo.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogoSillas {
    private String archivo;
    private List<Silla> sillas;


    public CatalogoSillas(String archivo) {
        this.archivo = archivo;
        this.sillas = new ArrayList<>();
    }

    public void readingData() {
        File file = new File(this.archivo);

        try (Scanner lector = new Scanner(file)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(",");


                for (int i = 0; i < datos.length; i++) {
                    datos[i] = datos[i].trim();
                }

                String referencia = datos[0];
                String categoria = datos[1];
                float precio = Float.parseFloat(datos[2]);
                float calificacion = Float.parseFloat(datos[3]);

                switch (categoria.toLowerCase()) {
                    case "presidencial":
                        String origen = datos[4];
                        sillas.add(new Presidencial(referencia, precio, calificacion, origen));
                        break;
                    case "gerencial":
                        sillas.add(new Gerencial(referencia, precio, calificacion));
                        break;
                    case "secretarial":
                        sillas.add(new Secretarial(referencia, precio, calificacion));
                        break;
                    case "tandem":

                        int puestos = Integer.parseInt(datos[4]);
                        sillas.add(new Tandem(referencia, precio, calificacion, puestos));
                        break;
                    case "de ruedas":

                        String traccion = datos[4];
                        sillas.add(new SillaDeRuedas(referencia, precio, calificacion, traccion));
                        break;
                    case "masajeadora":

                        int modos = Integer.parseInt(datos[4]);
                        String calefaccion = datos[5];
                        sillas.add(new Masajeadora(referencia, precio, calificacion, modos, calefaccion));
                        break;
                    default:
                        System.out.println("Categoría desconocida: " + categoria);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo " + archivo);
        } catch (Exception e) {
            System.out.println("Error al procesar los datos: " + e.getMessage());
        }
    }


    public List<Silla> getSillas() {
        return sillas;
    }
}
