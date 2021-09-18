/*

 Autor: Andrés Estuardo Montoya Wilhelm
 Programa: Memoria.java
 Creación: 10/9/2021   Modificación: 17/9/2021
 Lenguaje: Java
    
*/
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Memoria {
    String tipo;
    int memoria;//memoria en MB
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
        for(int i=0;i<nespacios;i++){//inicializar espacios
            espacios.add(new Espacio_memoria());
        }
    }

    public Memoria(int memoria){//SDR
        espacios = new ArrayList<Espacio_memoria>();
        cola=new LinkedList<Programa>();
        tipo="SDR";
        this.memoria=memoria*1024;
        int nespacios= (this.memoria)/64;
        for(int i=0;i<nespacios;i++){//inicializar espacios
            espacios.add(new Espacio_memoria());
        }
    }
    
    /** 
     * @return int
     */
    public int getMemoria(){//obtener la memoria total en MB
        return memoria;
    }
    
    /** 
     * @return int
     */
    public int getMemoria_uso(){//devuelve la memoria usada en MB
        int cont=0;
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).getPrograma()!=null){//contar todos los espacios llenos
                cont++;
            }
        }
        return (cont*64);
    }
    
    /** 
     * @return int
     */
    public int getMemoria_libre(){//regresa la memoria libre
        int cont=0;
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).getPrograma()==null){//contar todos los espacios vacios
                cont++;
            }
        }
        return (cont*64);
    }
    
    /** 
     * @return String
     */
    public String getCola(){//devuelve la cola de ejecución en eun string
        if(cola.size()!=0){
            Programa[] temp = new Programa[cola.size()];
            String scola = "|";
            for(int i=0; i<cola.size();i++){
                temp[i]=cola.poll();//saca los elementos de la cola
                scola=scola+temp[i].getNombre()+"|";//los copia en un string
                cola.add(temp[i]);//los regresa a la cola
            }
            return scola;//devuelve el string
        }else{
            return "Cola vacia";
        }
    }
    
    /** 
     * @return String[]
     */
    public String[] getProgramas(){//devuelve los programas disponibles en un array
        String[] arrprogramas =new String[programas.size()];
        for(int i=0;i<programas.size();i++){
            arrprogramas[i]=programas.get(i).getNombre();
        }
        return arrprogramas;
    }
    
    /** 
     * @param index
     */
    public void iniciar_programa(int index){//inicia un programa por medio del indice en la lista
        Programa programa=programas.get(index);
        int nespacios =(int)Math.ceil(Double.valueOf(programa.getEspacio())/64.00);//cantidad de espacios que ocupa el programa
        int espacios_vacios=0;
        
        for(int i=0; i<espacios.size();i++){//verifica la cantidad de espacios vacios en la memoria
            if(espacios.get(i).getPrograma()==null){
                espacios_vacios++;
            }
        }
        if(espacios_vacios>=nespacios){//verifica que quepa
            for(int i=0;i<nespacios;i++){
                boolean bandera=false;
                for(int j=0; j<espacios.size()&&bandera==false;j++){//recorre los espacios vacios hasta llenarlos con lo necesario para el programa
                    if(espacios.get(j).getPrograma()==null){
                        bandera=true;
                        espacios.get(j).setPrograma(new Programa(programa.getNombre(), programa.getEspacio(), programa.getCiclos()));//ingresa el programa en el espacio
                    }
                }
            }
        }else{//si no cabe
            if(tipo=="DDR"){//si es DDR
                switch (memoria) {
                    case (4*1024)://verifica el tamaño actual
                        memoria=(8*1024);
                        int nuevos_espacios = ((8*1024)/64)-((4*1024)/64);//aumenta el tamaño
                        for(int i=0;i<nuevos_espacios;i++){//agrega los espacios necesarios
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);//por medio de recursión intenta ingresar de nuevo el programa
                        break;
                    case (8*1024):
                        memoria=(12*1024);
                        int nuevos_espacios2 = ((12*1024)/64)-((8*1024)/64);
                        for(int i=0;i<nuevos_espacios2;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);//por medio de recursión intenta ingresar de nuevo el programa
                        break;
                    case (12*1024):
                        memoria=(16*1024);
                        int nuevos_espacios3 = ((16*1024)/64)-((12*1024)/64);
                        for(int i=0;i<nuevos_espacios3;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);//por medio de recursión intenta ingresar de nuevo el programa
                        break;
                    case (16*1024):
                        memoria=(32*1024);
                        int nuevos_espacios4 = ((32*1024)/64)-((16*1024)/64);
                        for(int i=0;i<nuevos_espacios4;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);//por medio de recursión intenta ingresar de nuevo el programa
                        break;
                    case (32*1024):
                    memoria=(64*1024);
                        int nuevos_espacios5 = ((64*1024)/64)-((32*1024)/64);
                        for(int i=0;i<nuevos_espacios5;i++){
                            espacios.add(new Espacio_memoria());
                        }
                        iniciar_programa(index);//por medio de recursión intenta ingresar de nuevo el programa
                        break;
                    case (64*1024)://si el espacio es el maximo
                        cola.add(new Programa(programa.getNombre(), programa.getEspacio(), programa.getCiclos()));//mete el programa a la cola
                        break;
                    default:
                        break;
                }
            }else if(tipo=="SDR"){//si es SDR
                cola.add(new Programa(programa.getNombre(), programa.getEspacio(), programa.getCiclos()));//agrega el programa a la cola
            }
        }
    }
    
    /** 
     * @return String
     */
    public String mostrar_espacios(){//devuelve visualmente los espacios de memoria
        String[] mespacios = new String[espacios.size()];
        for(int i=0; i<espacios.size();i++){
            if(espacios.get(i).getPrograma()==null){//crea un array con los espacios y sus ciclos restantes
                mespacios[i]="null";
            }else{
                mespacios[i]=espacios.get(i).getPrograma().getNombre()+" ("+espacios.get(i).getPrograma().getCiclos()+")";
            }
        }
        String sespacios="|  ";
        for(int i=0;i<mespacios.length;i++){//concatena todo en un string con separadores
            sespacios=sespacios+mespacios[i]+"  |  ";
        }
        return sespacios;
    }
    
    /** 
     * @return String
     */
    public String programas_en_ejecucion(){//devuelve los programas en ejecucion
        ArrayList<String> ejecucion = new ArrayList<String>();
        for(int i=0;i<espacios.size();i++){//recorre los espacios
            if(espacios.get(i).getPrograma()!=null){//busca los espacios con programas
                if(!ejecucion.contains(espacios.get(i).getPrograma().getNombre())){//verfica nombres repetidos
                    ejecucion.add(espacios.get(i).getPrograma().getNombre());//llena un array con los programas en ejecución
                }
            }
        }
        String sejecucion="";
        if(ejecucion.isEmpty()){//verifica que si hayan programas
            sejecucion="No hay programas en ejecucion";
        }else{
            for(int i=0;i<ejecucion.size();i++){//muestra los programas en ejecución
                sejecucion=sejecucion+ejecucion.get(i)+"\n";
            }
        }
        return sejecucion;
        
    }
    
    /** 
     * @return int
     */
    public int espacios_usados(){//devuelve la cantidad de espacios usados
        int usados=0;
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).getPrograma()!=null){
                usados++;
            }
        }
        return usados;
    }
    public void ciclo_de_reloj(){//realiza un xixlo de reloj
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
            while(bandera){//ciclo de reducción de espacios
                int cont=0;
                switch (memoria) {
                    case (64*1024)://verifica el espacio actual
                        if(espacios_usados()<=((32*1024)/64)){//verifica si puede ser reducido
                            memoria=32*1024;//reduce el espacio
                            for(int i=0;i<espacios.size()&&cont!=(((64*1024)/64)-((32*1024)/64));i++){//recorre los espacios a eliminar
                                if(espacios.get(i).getPrograma()==null){//elimina los espacios vacios
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
                        }else{//si ya no se puede reducir, detiene el ciclo
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
