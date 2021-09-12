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
    public ArrayList<Programa> leerArchivo(){
        try{
            FileReader fr = new FileReader("Programas.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(",");
                programas.add(new Programa(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2])));
            }
        }catch(IOException e){

        }
        return programas;
    }
    public int contarLineas(){
        int cont=0;
        try{
            FileReader fr = new FileReader("Programas.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                cont++;
            }
        }catch(IOException e){

        }
        return cont;
    }
}
