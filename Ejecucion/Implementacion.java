package Ejecucion;
import Herramientas.*;
import Laboratorio.*;
import Examenes.*;

public class Implementacion implements Maximos{
    //Objeto para manipular los vectores pacientes y examenes
    Datos dato = new Datos();
    
    //Vector para almacenar datos
    PacienteConOrden Paciente[] = new PacienteConOrden[MAX_PACIENTES];
    
    
    public void CargarDatos(){
        int cont = 0;
        for(int i=0;i<MAX_PACIENTES;i++){
            //Variables auxiliares
            int auxCant, auxEdad, auxId, auxResultS, auxHoras, auxCed;
            boolean auxResultB;
            double auxPrecio = 0;
            float auxPrecio2 = 0;
            char auxSex;
            String auxSex2, auxTelf, auxFecha="";
            
            String cadena = dato.getPacientes(i);
            String frag[] = cadena.split(" ");
            
            auxCed = Integer.parseInt(frag[2]);
            auxSex2 = frag[3];
            auxSex = auxSex2.charAt(0);
            
            try{
                auxCant = Integer.parseInt(frag[6]);
                auxEdad = Integer.parseInt(frag[4]);
                auxTelf = frag[5];
            }
            catch(IndexOutOfBoundsException e){
                auxCant = Integer.parseInt(frag[5]);
                auxEdad = 25;
                auxTelf = frag[4]; 
            }
            
            Examen v[] = new Examen[auxCant];
            
            for(int j=0;j<auxCant;j++){
                
                String cadena2 = dato.getExamen(cont);
                String frag2[] = cadena2.split("-");

                auxId = Integer.parseInt(frag2[3]);
                auxPrecio = Double.parseDouble(frag2[5]);
                auxPrecio2 = Float.parseFloat(frag2[5]);
                auxFecha = frag2[1];
            
                if(frag2[2].equals("S")){
                    auxResultS = Integer.parseInt(frag2[7]);
                    v[j] = new Sangre(auxId, frag2[4], auxPrecio2, frag2[6], auxResultS);
                }
                else if(frag2[2].equals("B")){
                    auxHoras = Integer.parseInt(frag2[6]);
                    auxResultB = Boolean.parseBoolean(frag2[7]);
                    v[j] = new Bacteriologia(auxId, frag2[4], auxPrecio2, auxHoras, auxResultB); 
                }
                
                cont++;
                  
            }
            
            PacienteConOrden obj = new PacienteConOrden();
            obj.setOrden(v);
            Paciente[i] = new PacienteConOrden(auxCed, frag[0], frag[1], auxSex, auxEdad, auxTelf, auxFecha, obj.getOrden(), auxPrecio);
        }
    }
    
    public void listadoSensibles(){   
        System.out.println("Listado general de pacientes \n");
        System.out.println("Cedula\t\t Apellido\t Nombre\t\t Sens. Bact.\t     Monto Pagado");
        for(int i=0; i<Paciente.length;i++){    
           System.out.print(Paciente[i].getCedula()+"\t"+Paciente[i].getApellido()+"\t\t "+Paciente[i].getNombre()+"\t\t");
           Paciente[i].calcularSensibilidad();
           System.out.print("    \t");
           Paciente[i].calcularMontoPagado();
        }
         System.out.print("\n\n");
    }
    
    public void listadoHormonal(){ 
        System.out.println("Pacientes con perfil hormonal \n");
        System.out.println("Nombre   Apellido   Descripcion del Examen    Resultado");
        
        for(int i=0; i<Paciente.length;i++){  
            int cont = 0, aux=0;
            
            Examen v[] = Paciente[i].getOrden();
            Sangre obj = new Sangre();
            
            while(cont<v.length){
                if(v[cont] instanceof Sangre){
                    obj = (Sangre) v[cont];
                    if(obj.getPerfil().equals("Hormonal")){
                        if(aux<1){
                            System.out.println(Paciente[i].getNombre()+"\t"+Paciente[i].getApellido()+"\t\t"+obj.getDescripcion()+"\t\t"+obj.getResultado());
                            aux++;
                        }
                        else{
                            System.out.println("\t\t\t"+obj.getDescripcion()+"\t\t"+obj.getResultado());
                        }
                    }
                }
                cont++;
            }
        } 
    }

    public static void main(String[] args) {
        //Objeto para implementar los metodos
         Implementacion obj =new Implementacion();
         obj.CargarDatos();
         obj.listadoSensibles();
         obj.listadoHormonal();
    }
    
}
