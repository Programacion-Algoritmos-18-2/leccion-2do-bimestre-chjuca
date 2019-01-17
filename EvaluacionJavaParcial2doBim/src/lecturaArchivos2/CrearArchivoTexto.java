/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;
import java.io.FileNotFoundException;               // Importamos las librerias necesarias
import java.lang.SecurityException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// import com.deitel.jhtp7.cap14.RegistroCuenta;
public class CrearArchivoTexto {                    //Creamos la clase para CrearArchivoTexto

    private Formatter salida;       // Objeto usado para enviar texto al archivo

    public void abrirArchivo() {    // Creamos la funcion abrir archivo 
        try {                       // lineas que tratamos de ejecutar pero pueden presentar un error
            salida = new Formatter("data/ListaNombres.csv");    //Creamos un archivo en la ruta mostrata
        } // fin de try
        catch (SecurityException securityException) {           // Execepciones que se pueden presentar 
            System.err.println("No tiene acceso de escritura a este archivo."); // Presentamos un mensaje en caso que se presente un error
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {  // Execepciones que se pueden presentar
            System.err.println("Error al crear el archivo."); // Presentamos un mensaje en caso que se presente un error
            System.exit(1);
        } // fin de catch
    }

    public void agregarRegistros(ArrayList<Profesor> lista) { // Metodo para Agregar registros al archivo
        try {               // lineas que tratamos de ejecutar pero pueden presentar un error
            for (int i = 0; i < lista.size(); i++) {     // for que va de 0 hasta la cantidad de elementos en size
                Profesor p = lista.get(i); 
                salida.format("%s|%s|%s|%s|%s|%s|%s|%s\n", p.getCedula(), p.getNombres(), p.getZona(), p.getProvincia(), p.getCanton(), p.getPersonalidad(),p.getRazonamiento(), p.getDirectamenIdoniedad());
            }       // Escribimos en el archivo segun el tipo de formato mostrado
        } catch (FormatterClosedException formatterClosedException) {       //Excepciones que podrian presentarse
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
        } // fin de catch

    } 
    public void cerrarArchivo() {       // Metodo que cerrara el archivo 
        if (salida != null) {
            salida.close();         
        }
    }
} 