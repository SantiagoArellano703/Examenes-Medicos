package Laboratorio;

public abstract class Persona {
    //Atributos
    private String apellido, nombre, telf;
    private int edad, cedula;
    private char sexo;
    
    //Constructores
    //Por defecto
    public Persona(){
        cedula=0;
        apellido="";
        nombre="";
        sexo= ' ';
        edad=0;
        telf="";
    }   
    
    //Parametrico

    public Persona(int cedula, String apellido, String nombre, char sexo, int edad, String telf) {
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.telf = telf;
    }
    
    //Getters
    public int getCedula() {
        return cedula;
    }

    public String getTelf() {
        return telf;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }
    
    //Metodos
    
    abstract String getNombreCompleto(); 
}
