/*

 Autor: Andrés Estuardo Montoya Wilhelm
 Programa: Espacio_memoria.java
 Creación: 10/9/2021   Modificación: 17/9/2021
 Lenguaje: Java
    
*/
public class Espacio_memoria {
    int espacio;
    Programa programa;
    public Espacio_memoria(){
        programa = null;
        espacio = 64;
    }
    
    /** 
     * @return int
     */
    public int getEspacio(){//obtener el espacio
        return espacio;
    }
    
    /** 
     * @return Programa
     */
    public Programa getPrograma(){//obtener el programa dentro del espacio
        return programa;
    }
    
    /** 
     * @param programa
     */
    public void setPrograma(Programa programa){//colocar un pedazo del programa
        this.programa=programa;
    }
}
