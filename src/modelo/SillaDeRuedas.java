package modelo;

public class SillaDeRuedas extends Silla{

    private String traccion;

    public SillaDeRuedas(String referencia, float precio, float calificacion, String traccion) {
        super(referencia, precio, calificacion);
        this.traccion = traccion;

    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
}
