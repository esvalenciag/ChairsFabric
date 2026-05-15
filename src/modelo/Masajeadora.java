package modelo;

public class Masajeadora extends  Silla{
    private int modosDeUso;
    private String calefaccion;

    public Masajeadora(String referencia, float precio, float calificacion, int modosDeUso, String calefaccion) {
        super(referencia, precio, calificacion);
        this.modosDeUso = modosDeUso;
        this.calefaccion = calefaccion;
    }

    @Override
    public String toString() {
        return "Masajeadora{" +
                "modosDeUso=" + modosDeUso +
                ", calefaccion='" + calefaccion + '\'' +
                '}';
    }

    public int getModosDeUso() {
        return modosDeUso;
    }

    public void setModosDeUso(int modosDeUso) {
        this.modosDeUso = modosDeUso;
    }

    public String getCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(String calefaccion) {
        this.calefaccion = calefaccion;
    }
}
