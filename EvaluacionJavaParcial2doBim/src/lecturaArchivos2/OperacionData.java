/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author reroes
 */
public class OperacionData {                                //Creacion de la clase OperacionData

    ArrayList<Profesor> informacion = new ArrayList<>();        // Atributos de la clase
    Scanner e=new Scanner(System.in);

    public void agregarInformacion(ArrayList<Profesor> info) {      // Metodo para Agregar informacion  a los atributos de la clase
        //informacion = new ArrayList<Profesor>(info.subList(0, 100));
        informacion =info;
    }

    public ArrayList<Profesor> obtenerInformacion() {       // Metodo para obtener informacion 
        return informacion;
    }
    
    public void ordenarPorCanton(){                         // proceso de ordenar, a través del uso de Collections
        ArrayList<Profesor> dataPorCantones = new ArrayList<>(); // creacmos una lista vacia de tipo Profesor
        dataPorCantones.addAll(informacion);                    // Agregamos todos los elementos de informacion a la lista vacia
        Collections.sort(dataPorCantones, 
                        (o1, o2) -> o1.canton.compareTo(o2.canton));        // Ordenamos la lista por el atributo Canton 
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.printf("%s",dataPorCantones.get(i));             // Prsentamos la lista Ordenada
        }
    }
    public void CantidadPersonalidad(){                 // Metodo para Calcular la cantidad de Personalidad segun su estado
        int cont=0;                         // contador 
        String llave;                       // Estado de el atributo
        System.out.printf("¿Desea obtener la cantidad de participantes por ADECUADOR (A) o POR CONVOCAR (C)?: ");  
        char opt=e.next().charAt(0);
        if (opt=='A' || opt=='a') {         // Condicion para determinar la eleccion del usuario
            llave="ADECUADO";
        }else{                              // llave toma valor segun la opcion del usuario
            llave="POR CONVOCAR";
        }
        for (int i = 0; i < this.informacion.size(); i++) {
            if(this.informacion.get(i).getPersonalidad().equals(llave)){    // Recorremos la lista y comparamos 
                cont+=1;
            }
        }
        System.out.printf("La cantidad de participantes por %s es %d\n",llave,cont);    // Presentamos el valor de cont
    }
    public void CantidadDictamenIdoniedad(){        // Metodo para Calcular la cantidad de Dictamen segun su estado
        int cont=0;             // contador
        String llave;           // Estado de el atributo
        System.out.printf("¿Desea obtener la cantidad de participantes por IDONEO (I) o NO IDONEO (N)?: ");
        char opt=e.next().charAt(0);
        if (opt=='I' || opt=='i') {         // Condicion para determinar la eleccion del usuario
            llave="IDONEO";
        }else{                          // llave toma valor segun la opcion del usuario
            llave="NO IDONEO";
        }
        for (int i = 0; i < this.informacion.size(); i++) {
            if(this.informacion.get(i).getDirectamenIdoniedad().equals(llave)){     // Recorremos la lista y comparamos 
                cont+=1;
            }
        }
        System.out.printf("La cantidad de participantes por %s es %d\n",llave,cont);    // Presentamos el valor de cont
    }
    
    public ArrayList<Profesor> ordenarPorNombres(){                 // Metodo que permite Ordenar la lista por Nombre
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();     // Creamos una lista vacia
        dataPorNombres.addAll(informacion);                        // Agregamos todos los elementos de informacion a la lista vacia 
        Collections.sort(dataPorNombres, 
                        (o1, o2) -> o1.nombres.compareTo(o2.nombres));  // Ordenamos la lista por el atributo nombre
        return dataPorNombres;
        
    }
    
    public void lecturaData() {                                 // metodo para Presentar la lista
        for (int i = 0; i<obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));    // Recorremos la lista y presentamos el elemento
        }
        
    }

}
