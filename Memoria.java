import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Memoria {
    String tipo;
    int memoria;
    Archivos archivo = new Archivos();
    ArrayList<Espacio_memoria> espacios;
    ArrayList<Programa> programas=archivo.leerArchivo();
    Queue<Programa> cola;
    public Memoria(){//DDR
        espacios = new ArrayList<Espacio_memoria>();
        cola=new LinkedList<Programa>();
        tipo="DDR";
        memoria=4*1024;
        int nespacios= (memoria)/64;
        for(int i=0;i<nespacios;i++){
            espacios.add(new Espacio_memoria());
        }
    }
    public Memoria(int memoria){//SDR
        espacios = new ArrayList<Espacio_memoria>();
        tipo="SDR";
        this.memoria=memoria*1024;
        int nespacios= (this.memoria)/64;
        for(int i=0;i<nespacios;i++){
            espacios.add(new Espacio_memoria());
        }
    }
    public String[] getProgramas(){
        String[] arrprogramas =new String[programas.size()];
        for(int i=0;i<programas.size();i++){
            arrprogramas[i]=programas.get(i).getNombre();
        }
        return arrprogramas;
    }
}
