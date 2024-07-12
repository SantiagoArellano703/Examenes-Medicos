package Examenes;

public class Sangre extends Examen{
    //Atributos
    private String perfil;
    private int resultado;
    
    public Sangre(){
        super();
        perfil="";
        resultado=0;
    }

    public Sangre(int id, String descripcion, float precio, String perfil, int resultado) {
        super(id, descripcion, precio);
        this.perfil = perfil;
        this.resultado = resultado;
    }

    //Getters
    public String getPerfil() {
        return perfil;
    }

    public int getResultado() {
        return resultado;
    }
    
    
    
}
