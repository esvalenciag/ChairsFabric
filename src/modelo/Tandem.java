package modelo;


public class Tandem extends Silla{

    private int puestos;

    public Tandem(String referencia, float precio, float calificacion, int puestos) {
        super(referencia, precio, calificacion);
        this.puestos = puestos;
    }

    public int getPuestos() {
        return puestos;
    }

    public void setPuestos(int puestos) {
        this.puestos = puestos;
    }
}
