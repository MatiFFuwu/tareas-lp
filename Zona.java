public class Zona {
    private boolean completada;
    
    public Zona(){
        completada = false;
    }

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if(completada == true){
            System.out.println("No queda nada que hacer aquí...");
        }
    }

    public void setCompletada(boolean completada){
        this.completada = completada;
    }

    public boolean getCompletada(){
        return completada;
    }
}