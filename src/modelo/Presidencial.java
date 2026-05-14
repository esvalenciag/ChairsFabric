package modelo;

public class Presidencial extends Silla implements Removible{

    private String esImportada;

    public Presidencial(String esImportada, String referencia, float precio, float calificacion) {
        super(referencia, precio, calificacion);
        this.esImportada = esImportada;


    }
}
