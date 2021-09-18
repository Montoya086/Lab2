/*

 Autor: Andrés Estuardo Montoya Wilhelm
 Programa: Archivos.java
 Creación: 10/9/2021   Modificación: 17/9/2021
 Lenguaje: Java
    
*/
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
public class Archivos {
    ArrayList<Programa> programas;
    public Archivos(){
        programas=new ArrayList<Programa>();
    }
    
    /** 
     * @return ArrayList<Programa>
     */
    public ArrayList<Programa> leerArchivo(){//devuelve los programas disponibles
        try{
            FileReader fr = new FileReader("Programas.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){//lee las lineas
                String[] datos=linea.split(",");
                programas.add(new Programa(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2])));//crea un nuevo programa por linea
            }
        }catch(IOException e){

        }
        return programas;
    }
    
    /** 
     * @return int
     */
    public int contarLineas(){//cuenta la cantidad de programas disponibles
        int cont=0;
        try{
            FileReader fr = new FileReader("Programas.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){//recorre las lineas
                cont++;
            }
        }catch(IOException e){

        }
        return cont;
    }
}
