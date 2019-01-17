package lecturaArchivos2;

// Fig. 14.11: LeerArchivoTexto.java
// Este programa lee un archivo de texto y muestra cada registro.
import java.io.File;                                // Importamos las librerias necesarias
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class LeerArchivoTexto {     // Creacion de la clase LeerArchivoTexto

    private Scanner entrada;     // Objeto usado para leer
    private Formatter salida;   // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrirArchivo(String ruta) {                 // Metodo que abrira el archivo
        try {               //// lineas que tratamos de ejecutar pero pueden presentar un error
            entrada = new Scanner(new File(ruta));  // Leemos el archivo en la ruta que recibimos como parametro
        } 
        catch (FileNotFoundException fileNotFoundException) {   // Posibles errores que pueden presentarse
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } 
    }
    
    public ArrayList<Profesor> leerRegistros_txt() { // Metodo que Lee registro del archivo txt

        OperacionData operacion = new OperacionData();      // creacion de objeto de tipo operacion 
        ArrayList<Profesor> lista = new ArrayList<>();      // Creacion de una lista vacia tipo Profesor

        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine();
            while (entrada.hasNext()) {
                Gson g = new Gson();    // se crea el objeto para leer Json
                String linea = entrada.nextLine();
                Profesor p = g.fromJson(linea, Profesor.class); // se hace el proceso de transformación
                lista.add(p);
                //System.out.println(p);

            } // fin de while

        } // fin de try
        catch (NoSuchElementException elementException) {           // Posibles errores que podrian presentarse
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;                       // Retornamos la lista tipo Profesor que creamos 
    } // fin del m�todo leerRegistros
    // cierra el archivo y termina la aplicaci�n

    public ArrayList<Profesor> leerRegistros_csv() {            // Funcion que nos devolvera una lista tipo Profesor que lo hara con el archivo csv

        ArrayList<Profesor> lista = new ArrayList<>();          // Creamos una lista vacia tipo profesor

        try // lee registros del archivo, usando el objeto Scanner
        {
            String linea = entrada.nextLine();
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                //System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(",")));    // separamos la cadena por el caracter ","
                Profesor p = new Profesor();        // Creamos un Objeto tipo Profesor
                p.setCedula(linea_partes.get(0));   // Agregamos valor a cada uno de los atributos del objeto valor con las funciones creadas
                p.setNombre(linea_partes.get(1));
                p.setZona(linea_partes.get(2));
                p.setProvincia(linea_partes.get(3));
                p.setCanton(linea_partes.get(4));
                p.setPersonalidad(linea_partes.get(5));
                p.setRazonamiento(linea_partes.get(6));
                p.setDirectamenIdoniedad(linea_partes.get(7));
                lista.add(p);

            } // fin de while
        } // fin de try     
        catch (NoSuchElementException elementException) {               // Posibles errores que pueden presentarse
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;                               // Devolvemos la lista
    } // fin del m�todo leerRegistros
    // cierra el archivo y termina la aplicaci�n

    public void cerrarArchivo() {                   // Metodo que permite cerrar el archivo
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
} // fin del m�todo agregarRegistros

// cierra el file
/**
 * ************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y * Pearson Education,
 * Inc. Todos los derechos reservados. * * RENUNCIA: Los autores y el editor de
 * este libro han realizado su mejor * esfuerzo para preparar este libro. Esto
 * incluye el desarrollo, la * investigaci�n y prueba de las teor�as y programas
 * para determinar su * efectividad. Los autores y el editor no hacen ninguna
 * garant�a de * ning�n tipo, expresa o impl�cita, en relaci�n con estos
 * programas o * con la documentaci�n contenida en estos libros. Los autores y
 * el * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de * estos
 * programas. *
 * ***********************************************************************
 */
