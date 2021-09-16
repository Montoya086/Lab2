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
