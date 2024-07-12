package Laboratorio;
import Examenes.*;
import Herramientas.Datos;
import java.text.DecimalFormat;

public class PacienteConOrden extends Persona{
    //Objeto para determinar la longitud del vector examen
    Datos dato = new Datos();
    
    //Atributos
    private String fecha;
    private Examen orden[] = new Examen[dato.longExamenes()];
    private double montoPagado;
    
    public PacienteConOrden(){
    }
    
    //Constructor Parametrico
    public PacienteConOrden(int cedula, String apellido, String nombre, char sexo, int edad, String telf, String fecha, Examen[] orden, double montoPagado) {
        super(cedula, apellido, nombre, sexo, edad, telf);
        this.fecha = fecha;
        this.orden = orden;
        this.montoPagado = montoPagado;
    
    }
    
    //Setters
    public void setOrden(Examen[] orden) {
        this.orden = orden;
    }

    //Getters
    public Examen[] getOrden() {
        return orden;
    }

    public double getMontoPagado() {
        return montoPagado;
    }
    
    //Metodos
    @Override
    public String getNombreCompleto(){
        String cadena;
        cadena = getNombre()+" "+getApellido();
        return cadena;
    }
    
    //Sobrecarga del metodo
    public String getNombreCompleto(String i){
        String cadena;
        cadena = getCedula()+" "+getApellido()+" "+getNombre();
        return cadena;
      }
    
    public void calcularSensibilidad(){
        int cont=0, i=0;
        Bacteriologia obj = new Bacteriologia();
                
        while(cont<orden.length){
            
            if(orden[i] instanceof Bacteriologia){
                obj = (Bacteriologia) orden[i];
                
                if(obj.getResultado()){
                    System.out.print("<Es sensible>");
                    cont = orden.length;
                }
            }
            
            if (cont==(orden.length-1)){
                System.out.print("<No es sensible>");
            } 
            i++;
            cont++;
        } 
    }
    
    public void calcularMontoPagado(){
        montoPagado=0;
        
        for(int i=0;i<orden.length;i++){
            montoPagado = montoPagado + orden[i].calcularPrecioReal();
        } 
        
        if(orden.length>3){
            montoPagado = montoPagado-(montoPagado*0.08);
        }
        
        DecimalFormat formato =new DecimalFormat("#.00");
        
        System.out.println(formato.format(montoPagado));
    }
}
