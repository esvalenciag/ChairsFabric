package modelo;

public class Gerencial extends Silla implements Removible{

    public Gerencial(String referencia, float precio, float calificacion) {
        super(referencia, precio, calificacion);
    }



    @Override
    public String removerDelCatalogo(){
        if (this.calificacion < 4 || this.precio > 300000){
            return "Remover";
        }
        return "Mantener";
    }

}
