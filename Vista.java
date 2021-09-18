/*

 Autor: Andrés Estuardo Montoya Wilhelm
 Programa: Vista.java
 Creación: 10/9/2021   Modificación: 17/9/2021
 Lenguaje: Java
    
*/
import java.util.Scanner;
public class Vista {
    Scanner sc = new Scanner(System.in);
    
    /** 
     * @return int
     */
    public int menu(){//despliega el menu
        try{
            System.out.println("Elija una de las siguientes opciones:");
            System.out.println("1.Iniciar un programa");
            System.out.println("2.Mostrar memoria en MB");
            System.out.println("3.Mostrar programas en ejecución");
            System.out.println("4.Mostrar cola de ejecución");
            System.out.println("5.Mostrar espacios");
            System.out.println("6.Ciclo de reloj");
            System.out.println("7.Salir");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    
    /** 
     * @param s
     */
    public void mostrar_cola(String s){//muestra la cola de ejecución
        System.out.println(s);
    }
    public void elegir_programa(){//mensaje para elegir los programas
        System.out.println("Elija uno de los programas disponibles:");
    }
    
    /** 
     * @param i
     * @param nombre
     */
    public void lista_programas(int i, String nombre){//mostrar la lista de programas
        System.out.println(i+". "+nombre);
    }
    
    /** 
     * @return int
     */
    public int pedir_programa(){//ingreso de el programa
        return Integer.parseInt(sc.nextLine());
    }
    public void no_programas(){//mensaje: no hay programas
        System.out.println("Actualmente no hay programas disponibles");
    }
    
    /** 
     * @return int
     */
    public int pedir_tipo_memoria(){// listado de memorias disponibles
        try{
            System.out.println("Elija una de las siguientes opciones de memoria:");
            System.out.println("1.SDR");
            System.out.println("2.DDR");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    
    /** 
     * @return int
     */
    public int pedir_memoria(){//pedir el tamaño de la memoria
        try{
            System.out.println("Elija una de las siguientes opciones de tamaño:");
            System.out.println("1. 4GB");
            System.out.println("2. 8GB");
            System.out.println("3. 12GB");
            System.out.println("4. 16GB");
            System.out.println("5. 32GB");
            System.out.println("6. 64GB");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    public void ingrese_valor_valido(){//mensaje de ingresar un valor valido
        System.out.println("Ingrese un valor valido");
    }
    
    /** 
     * @param s
     */
    public void mostrar_espacios(String s){//mostrar los espacios de forma visual
        System.out.println(s);
    }
    public void ciclo_reloj(){//un relojito uwu (para los ciclos)
        System.out.println("         #@@@*   *@@@#        ");
        System.out.println("       @@      @      @@      ");
        System.out.println("     @@        @        @@    ");
        System.out.println("    @@         @         @@   ");
        System.out.println("    @          (@@@@@@    @   ");
        System.out.println("    @@                   @@   ");
        System.out.println("     @@                 @@    ");
        System.out.println("       @@             @@      ");
        System.out.println("         #@@@,   *@@@(        ");
    }
    
    /** 
     * @param s
     */
    public void programas_ejecucion(String s){//mostrar los programas en ejecucion
        System.out.println(s);
    }
    
    /** 
     * @param m
     */
    public void memoria_total(int m){//mostrar memoria total
        System.out.println("Memoria total: "+m+"MB");
    }
    
    /** 
     * @param m
     */
    public void memoria_uso(int m){//mostrar memoria en uso
        System.out.println("Memoria en uso: "+m+"MB");
    }
    
    /** 
     * @param m
     */
    public void memoria_libre(int m){//mostrar memoria libre
        System.out.println("Memoria libre: "+m+"MB");
    }
    public void separador(){//separador de acciones
        System.out.println("\n**********************************************\n");
    }
    
    /** 
     * @return int
     */
    public int numero_programas_inicio(){//ingreso de la cantidad de programas para iniciar la memoria
        System.out.println("Ingrese el numero de programas con los que iniciará la memoria: ");
        return Integer.parseInt(sc.nextLine());
    }
}
