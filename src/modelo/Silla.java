package modelo;

public abstract class Silla {
    private String referencia;
    private float precio;
    private float calificacion;


    public Silla(String referencia, float precio, float calificacion) {
        this.referencia = referencia;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

}
