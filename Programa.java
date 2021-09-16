public class Programa {
    String nombre;
    int espacio;
    int ciclos;
    public Programa(String nombre, int espacio, int ciclos){//inicializa un programa
        this.nombre=nombre;
        this.espacio=espacio;
        this.ciclos=ciclos;
    }
    
    /** 
     * @return String
     */
    public String getNombre(){//devuelve el nombre
        return nombre;
    }
    
    /** 
     * @return int
     */
    public int getEspacio(){//devuelve el espacio
        return espacio;
    }
    
    /** 
     * @return int
     */
    public int getCiclos(){//devuelve sus ciclos
        return ciclos;
    }
    public void setCiclos(){//disminuye sus ciclos
        ciclos--;
    }
}
