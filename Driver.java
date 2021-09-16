public class Driver {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Vista v = new Vista();
        Memoria memoria;
        int r1=0;
        while(r1!=1 && r1!=2){//ciclo para pedir tipo de memoria
            r1=v.pedir_tipo_memoria();
        }
        if(r1==1){//SDR
            int rmemoria=0;
            while(!(rmemoria>=1 && rmemoria<=6)){//ciclo para pedir el tamaño de la memoria SDR
                rmemoria=v.pedir_memoria();
            }
            switch (rmemoria) {//opciones de memoria
                case 1://4GB
                    memoria=new Memoria(4);
                    break;
                case 2://8GB
                    memoria=new Memoria(8);
                    break;
                case 3://12GB
                    memoria=new Memoria(12);
                    break;
                case 4://16Gb
                    memoria=new Memoria(16);
                    break;
                case 5://32GB
                    memoria=new Memoria(32); 
                    break;
                case 6://64GB
                    memoria=new Memoria(64);
                    break;
                default:
                    memoria=new Memoria(4);
                    break;
            }
        }else{//DDR
            memoria=new Memoria();
        }
        int r2=-1;
        while(r2<0){//numero de programas de inicio
            r2=v.numero_programas_inicio();
        }
        String[] programas = memoria.getProgramas();//lista de programas disponibles
        if(programas.length!=0){// ver si hay programas
            for(int i=0;i<r2;i++){//cantidad de programas a elegir
                
                    int rprograma =0;
                    while(!(rprograma>=1 && rprograma<=(programas.length))){//validación de numeros
                        v.elegir_programa();
                        for(int j=0;j<programas.length;j++){//eleir programa
                            v.lista_programas(j+1, programas[j]);
                        }
                        rprograma= v.pedir_programa();
                    }
                    memoria.iniciar_programa(rprograma-1);//iniciar el programa
                
            }
        }else{//no hay programas
            v.separador();
            v.no_programas();
            v.separador();
        }
        int r=0;
        while(r!=7){
            r=v.menu();
            if(r!=0){
                switch (r) {
                    case 1://iniciar un programa
                        if(programas.length!=0){//ver si hay programas disponibles
                            int rprograma =0;
                            while(!(rprograma>=1 && rprograma<=(programas.length))){//validación de numeros
                                v.elegir_programa();
                                for(int i=0;i<programas.length;i++){//eleir programa
                                    v.lista_programas(i+1, programas[i]);
                                }
                                rprograma= v.pedir_programa();//iniciar el programa
                            }
                            memoria.iniciar_programa(rprograma-1);
                        }else{//no hay programas
                            v.separador();
                            v.no_programas();
                            v.separador();
                        }
                        break;
                    case 2://mostrar memoria
                        v.separador();
                        v.memoria_total(memoria.getMemoria());//memoria total
                        v.memoria_uso(memoria.getMemoria_uso());//memoria en uso
                        v.memoria_libre(memoria.getMemoria_libre());//memoria libre
                        v.separador();
                        break;
                    case 3://mostrar programas en ejecucion
                        v.separador();
                        v.programas_ejecucion(memoria.programas_en_ejecucion());//lista de programas en ejecución
                        v.separador();
                        break;
                    case 4://mostrar cola de ejecucion
                        v.separador();
                        v.mostrar_cola(memoria.getCola());//mostrar la cola de ejecución
                        v.separador();
                        break;
                    case 5://Mostrar espacios
                        v.mostrar_espacios(memoria.mostrar_espacios());//mostrar espacios
                        break;
                    case 6://ciclos de reloj
                        v.separador();
                        v.ciclo_reloj();
                        memoria.ciclo_de_reloj();//hacer un ciclo de reloj
                        v.separador();
                        break;
                    case 7://salir              
                        break;               
                    default:
                        break;
                }
            }else{
                v.ingrese_valor_valido();
            }
        }
    }
}
