package lecturaArchivos2;

// Fig. 14.12: PruebaLeerArchivoTexto.java
import java.util.ArrayList;

public class PruebaLeerArchivoTexto {           // Clase Pirncipal

    public static void main(String args[]) {  
        
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();   // Creamos un Objeto de tipo LeerArchivoTexto
        OperacionData operacion = new OperacionData();          // Creamos un Objeto de tipo OperacionData

        aplicacion.abrirArchivo("data/data1.csv");              // Llamamos al metodo abrirArchivo y le enviamos la ruta del archivo
        ArrayList<Profesor> lista_csv = aplicacion.leerRegistros_csv();     // Creamos una lista con la lista que nos devolvera la funcion leerRegistros_csv
        aplicacion.abrirArchivo("data/data2.txt");              // Llamamos al metodo abrirArchivo y le enviamos la ruta del archivo
        ArrayList<Profesor> lista_txt = aplicacion.leerRegistros_txt();     // Creamos una lista con la lista que nos devolvera la funcion leerRegistros_txt
        
        ArrayList<Profesor> lista_participantes = new ArrayList<>();        //Creamos una lista de tipo Profesor vacia
        for (int i = 0; i < lista_csv.size(); i++) {
            lista_participantes.add(lista_csv.get(i));                      // Agregamos a la lista_participantes los valores de lsta_csv
        }
        for (int i = 0; i < lista_txt.size(); i++) {
            lista_participantes.add(lista_txt.get(i));                      // Agregamos a la lista_participantes los valores de lsta_txt
        }

        operacion.agregarInformacion(lista_participantes);                  // llamamos a la funcion AgregarInformacion y le enviamos la lista_particiapntes

        operacion.ordenarPorCanton();                           // Llamamos a la funcion OrdenarCanton
        ArrayList<Profesor> listaNombres = operacion.ordenarPorNombres();   // Creamos y damos valor a listaNombres con lo que nos devolvera la funcion OrdenarPorNombre
        CrearArchivoTexto archivo= new CrearArchivoTexto();             // Creamos un objeto de tipo CrearArchivoTexto
        archivo.abrirArchivo();                     // Llamamos a la funcion abrirArchivo
        archivo.agregarRegistros(listaNombres);     // llamamos a la funcion agregarRegistros y le enviamos la listaNombres         
        operacion.CantidadPersonalidad();           // Llamamos a la funcion CantidadPersonalidad
        operacion.CantidadDictamenIdoniedad();      // Llamamos a la funcion CantidadDictamenIdoniedad
        aplicacion.cerrarArchivo();                 // Cerramos los archivos
        archivo.cerrarArchivo();
        
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

