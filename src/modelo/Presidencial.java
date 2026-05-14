package modelo;

public class Presidencial extends Silla implements Removible{

    private String esImportada;

    public Presidencial(String referencia, float precio, float calificacion, String esImportada) {
        super(referencia, precio, calificacion);
        this.esImportada = esImportada;
    }

    public String getEsImportada() {
        return esImportada;
    }

    public void setEsImportada(String esImportada) {
        this.esImportada = esImportada;
    }

    @Override
    public String removerDelCatalogo(){
        if (this.esImportada.equalsIgnoreCase("si") && (this.calificacion < 3.5f || this.precio > 400000)){
            return "Remover";
        }
        return "Mantener";
    }

}
