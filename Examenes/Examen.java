package Examenes;

public class Examen {
   //Atributos
    private int id;
    private String descripcion;
    private float precio;
    
    // Contructores
    // Por defecto
    public Examen(){
        id = 0;
        descripcion = "";
        precio = 0F;
    }

    //Parametrico
    public Examen(int id, String descripcion, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }
    
    // Metodos
    public float calcularPrecioReal(){
        float real=0F;
        real = (float) (precio+(precio*0.12));
        return real;
    }

    
    
}
