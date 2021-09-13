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
        cola=new LinkedList<Programa>();
        tipo="SDR";
        this.memoria=memoria*1024;
        int nespacios= (this.memoria)/64;
        for(int i=0;i<nespacios;i++){
            espacios.add(new Espacio_memoria());
        }
    }
    public int getMemoria(){
        return memoria;
    }
    public int getMemoria_uso(){
        int cont=0;
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).getPrograma()!=null){
                cont++;
            }
        }
        return (cont*64);
    }
    public int getMemoria_libre(){
        int cont=0;
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).getPrograma()==null){
                cont++;
            }
        }
        return (cont*64);
    }
    public String getCola(){
        if(cola.size()!=0){
            Programa[] temp = new Programa[cola.size()];
            String scola = "|";
            for(int i=0; i<cola.size();i++){
                temp[i]=cola.poll();
                scola=scola+temp[i].getNombre()+"|";
                cola.add(temp[i]);
            }
            return scola;
        }else{
            return "Cola vacia";
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
                        espacios.get(j).setPrograma(new Programa(programa.getNombre(), programa.getEspacio(), programa.getCiclos()));
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
                        memoria=(12*1024);
                        int nuevos_espacios2 = ((12*1024)/64)-((8*1024)/64);
                        for(int i=0;i<nuevos_espacios2;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);
                        break;
                    case (12*1024):
                        memoria=(16*1024);
                        int nuevos_espacios3 = ((16*1024)/64)-((12*1024)/64);
                        for(int i=0;i<nuevos_espacios3;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);
                        break;
                    case (16*1024):
                        memoria=(32*1024);
                        int nuevos_espacios4 = ((32*1024)/64)-((16*1024)/64);
                        for(int i=0;i<nuevos_espacios4;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);
                        break;
                    case (32*1024):
                    memoria=(64*1024);
                        int nuevos_espacios5 = ((64*1024)/64)-((32*1024)/64);
                        for(int i=0;i<nuevos_espacios5;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);
                        break;
                    case (64*1024):
                        cola.add(new Programa(programa.getNombre(), programa.getEspacio(), programa.getCiclos()));
                        break;
                    default:
                        break;
                }
            }else if(tipo=="SDR"){
                cola.add(new Programa(programa.getNombre(), programa.getEspacio(), programa.getCiclos()));
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
    public String programas_en_ejecucion(){
        ArrayList<String> ejecucion = new ArrayList<String>();
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).getPrograma()!=null){
                if(!ejecucion.contains(espacios.get(i).getPrograma().getNombre())){
                    ejecucion.add(espacios.get(i).getPrograma().getNombre());
                }
            }
        }
        String sejecucion="";
        if(ejecucion.isEmpty()){
            sejecucion="No hay programas en ejecucion";
        }else{
            for(int i=0;i<ejecucion.size();i++){
                sejecucion=sejecucion+ejecucion.get(i)+"\n";
            }
        }
        return sejecucion;
        
    }
    public int espacios_usados(){
        int usados=0;
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).getPrograma()!=null){
                usados++;
            }
        }
        return usados;
    }
    public void ciclo_de_reloj(){
        for(int i=0;i<espacios.size();i++){//disminuye los ciclos
            if(espacios.get(i).getPrograma()!=null){
                espacios.get(i).getPrograma().setCiclos();
            }
        }
        for(int i=0;i<espacios.size();i++){//elimina los ciclos en 0
            if(espacios.get(i).getPrograma()!=null){
                if(espacios.get(i).getPrograma().getCiclos()==0){
                    espacios.get(i).setPrograma(null);
                }
            }
        }
        if(cola.size()!=0){//comprobar si algun programa puede salir de la cola
            Programa temp2;
            for(int i=0; i<cola.size();i++){
                temp2=cola.poll();
                iniciar_programa(programas.indexOf(temp2));
            }
        }
        if(tipo == "DDR"){
            boolean bandera=true;
            while(bandera){
                int cont=0;
                switch (memoria) {
                    case (64*1024):
                        if(espacios_usados()<=((32*1024)/64)){
                            memoria=32*1024;
                            for(int i=0;i<espacios.size()&&cont!=(((64*1024)/64)-((32*1024)/64));i++){
                                if(espacios.get(i).getPrograma()==null){
                                    espacios.remove(i);
                                    cont++;
                                }
                            }
                        }else{
                            bandera=false;
                        }
                        break;
                    case (32*1024):
                        if(espacios_usados()<=((16*1024)/64)){
                            memoria=16*1024;
                            for(int i=0;i<espacios.size()&&cont!=(((32*1024)/64)-((16*1024)/64));i++){
                                if(espacios.get(i).getPrograma()==null){
                                    espacios.remove(i);
                                    cont++;
                                }
                            }
                        }else{
                            bandera=false;
                        }
                        break;
                    case (16*1024):
                        if(espacios_usados()<=((12*1024)/64)){
                            memoria=12*1024;
                            for(int i=0;i<espacios.size()&&cont!=(((16*1024)/64)-((12*1024)/64));i++){
                                if(espacios.get(i).getPrograma()==null){
                                    espacios.remove(i);
                                    cont++;
                                }
                            }
                        }else{
                            bandera=false;
                        }
                        break;
                    case (12*1024):
                        if(espacios_usados()<=((8*1024)/64)){
                            memoria=8*1024;
                            for(int i=0;i<espacios.size()&&cont!=(((12*1024)/64)-((8*1024)/64));i++){
                                if(espacios.get(i).getPrograma()==null){
                                    espacios.remove(i);
                                    cont++;
                                }
                            }
                        }else{
                            bandera=false;
                        }
                        break;
                    case (8*1024):
                        if(espacios_usados()<=((4*1024)/64)){
                            memoria=4*1024;
                            for(int i=0;i<espacios.size()&&cont!=(((8*1024)/64)-((4*1024)/64));i++){
                                if(espacios.get(i).getPrograma()==null){
                                    espacios.remove(i);
                                    cont++;
                                }
                            }
                        }else{
                            bandera=false;
                        }
                        break;
                
                    default:
                        bandera=false;
                        break;
                }
            }
        }
    }
}
