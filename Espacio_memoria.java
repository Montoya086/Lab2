public class Espacio_memoria {
    int espacio;
    Programa programa;
    public Espacio_memoria(){
        programa = null;
        espacio = 64;
    }
    public int getEspacio(){
        return espacio;
    }
    public Programa getPrograma(){
        return programa;
    }
    public void setPrograma(Programa programa){
        this.programa=programa;
    }
}
