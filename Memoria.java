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
    public void iniciar_programa(int index){
        Programa programa=programas.get(index);
        int nespacios =(int)Math.ceil(Double.valueOf(programa.getEspacio())/64.00);//cantidad de espacios que ocupa el programa
        int espacios_vacios=0;
        
        for(int i=0; i<espacios.size();i++){
            if(espacios.get(i).getPrograma()==null){
                espacios_vacios++;
            }
        }
        if(espacios_vacios>=nespacios){//verifica que quepa
            for(int i=0;i<nespacios;i++){
                boolean bandera=false;
                for(int j=0; j<espacios.size()&&bandera==false;j++){
                    if(espacios.get(j).getPrograma()==null){
                        bandera=true;
                        espacios.get(j).setPrograma(programa);
                    }
                }
            }
        }else{
            if(tipo=="DDR"){
                switch (memoria) {
                    case (4*1024):
                        memoria=(8*1024);
                        int nuevos_espacios = ((8*1024)/64)-((4*1024)/64);
                        for(int i=0;i<nuevos_espacios;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);
                        break;
                    case (8*1024):
                        
                        break;
                    case (12*1024):
                        
                        break;
                    case (16*1024):
                        
                        break;
                    case (32*1024):
                        
                        break;
                    case (64*1024):
                        cola.add(programa);
                        break;
                    default:
                        break;
                }
            }else if(tipo=="SDR"){
                cola.add(programa);
            }
        }
    }
    public String mostrar_espacios(){
        String[] mespacios = new String[espacios.size()];
        for(int i=0; i<espacios.size();i++){
            if(espacios.get(i).getPrograma()==null){
                mespacios[i]="null";
            }else{
                mespacios[i]=espacios.get(i).getPrograma().getNombre()+" ("+espacios.get(i).getPrograma().getCiclos()+")";
            }
        }
        String sespacios="|  ";
        for(int i=0;i<mespacios.length;i++){
            sespacios=sespacios+mespacios[i]+"  |  ";
        }
        return sespacios;
    }
}
