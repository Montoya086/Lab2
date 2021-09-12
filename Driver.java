public class Driver {
    public static void main(String[] args){
        Vista v = new Vista();
        Memoria memoria;
        int r1=0;
        while(r1!=1 && r1!=2){
            r1=v.pedir_tipo_memoria();
        }
        if(r1==1){//SDR
            int rmemoria=0;
            while(!(rmemoria>=1 && rmemoria<=6)){
                rmemoria=v.pedir_memoria();
            }
            switch (rmemoria) {
                case 1:
                    memoria=new Memoria(4);
                    break;
                case 2:
                    memoria=new Memoria(8);
                    break;
                case 3:
                    memoria=new Memoria(12);
                    break;
                case 4:
                    memoria=new Memoria(16);
                    break;
                case 5:
                    memoria=new Memoria(32); 
                    break;
                case 6:
                    memoria=new Memoria(64);
                    break;
                default:
                    memoria=new Memoria(4);
                    break;
            }
        }else{//DDR
            memoria=new Memoria();
        }
        int r=0;
        while(r!=7){
            r=v.menu();
            if(r!=0){
                switch (r) {
                    case 1://iniciar un programa
                        String[] programas = memoria.getProgramas();
                        if(programas.length!=0){
                            int rprograma =0;
                            while(!(rprograma>=1 && rprograma<=(programas.length))){
                                v.elegir_programa();
                                for(int i=0;i<programas.length;i++){
                                    v.lista_programas(i+1, programas[i]);
                                }
                                rprograma= v.pedir_programa();
                            }
                        }else{
                            v.no_programas();
                        }
                        break;
                    case 2://mostrar memoria
                        
                        break;
                    case 3://mostrar programas en ejecucion
                        
                        break;
                    case 4://mostrar cola de ejecucion
                        
                        break;
                    case 5://Mostrar espacios
                        
                        break;
                    case 6://ciclos de reloj
                        
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
