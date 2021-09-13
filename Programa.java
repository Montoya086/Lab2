public class Programa {
    String nombre;
    int espacio;
    int ciclos;
    public Programa(String nombre, int espacio, int ciclos){
        this.nombre=nombre;
        this.espacio=espacio;
        this.ciclos=ciclos;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEspacio(){
        return espacio;
    }
    public int getCiclos(){
        return ciclos;
    }
    public void setCiclos(){
        ciclos--;
    }
}
