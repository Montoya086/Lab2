import java.io.InputStream;
import java.util.Scanner;
public class Vista {
    Scanner sc = new Scanner(System.in);
    public int menu(){
        try{
            System.out.println("Elija una de las siguientes opciones:");
            System.out.println("1.Iniciar un programa");
            System.out.println("2.Mostrar memoria");
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
    public void elegir_programa(){
        System.out.println("Elija uno de los programas disponibles:");
    }
    public void lista_programas(int i, String nombre){
        System.out.println(i+". "+nombre);
    }
    public int pedir_programa(){
        return Integer.parseInt(sc.nextLine());
    }
    public void no_programas(){
        System.out.println("Actualmente no hay programas disponibles");
    }
    public int pedir_tipo_memoria(){
        try{
            System.out.println("Elija una de las siguientes opciones de memoria:");
            System.out.println("1.SDR");
            System.out.println("2.DDR");
            return Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    public int pedir_memoria(){
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
    public void ingrese_valor_valido(){
        System.out.println("Ingrese un valor valido");
    }
    public void mostrar_espacios(String s){
        System.out.println(s);
    }
}
