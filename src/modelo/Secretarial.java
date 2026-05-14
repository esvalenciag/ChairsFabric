package modelo;

public class Secretarial extends Silla implements Removible{

    public Secretarial(String referencia, float precio, float calificacion) {
        super(referencia, precio, calificacion);
    }

    @Override
    public String removerDelCatalogo(){
        if (this.calificacion < 3 || this.precio > 200000){
            return "Remover";
        }
        return "Mantener";
    }
}
