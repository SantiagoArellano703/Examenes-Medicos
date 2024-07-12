package Examenes;

public class Bacteriologia extends Examen{
    private int nroHoras;
    private boolean resultado;
    
    //Constructores
    //Por defecto
    public Bacteriologia(){
        super();
        nroHoras=0;
        resultado=false;
    }
    
    //Parametrico
    public Bacteriologia(int id, String descripcion, float precio, int nroHoras, boolean resultado) {
        super(id, descripcion, precio);
        this.nroHoras = nroHoras;
        this.resultado = resultado;
    }
    
    //Getters
    public boolean getResultado() {
        return resultado;
    }

    public int getNroHoras() {
        return nroHoras;
    }
    
    
    
}
