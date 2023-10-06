public class Zona {
    private boolean completada;
    
    public Zona(){
        completada = false;
    }
    //Constructor

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if(completada == true){
            System.out.println("No queda nada que hacer aquí...");
            System.out.println("");
        }
    }
    /************
     * Parametros: Pikinim
     * **********
     * Retorno: void
     * **********
     * Descripción: Le hace saber al usuario que no queda nada por hacer
     cuando la zona ya ha sido completada, como caso base.
     ************
     */

    public String carac(){
        String carac = ", COMPLETADO";
        return carac;
    }
    /************
     * Parametros: none
     * **********
     * Retorno: String
     * **********
     * Descripción: Entrega COMPLETADO cuando la zona ya ha sido completada, como caso base (no es necesario mostrar
     las características de lo que se haya encontrado ahí anteriormente).
     ************
     */

    public void setCompletada(boolean completada){
        this.completada = completada;
    }
    //Setter

    public boolean getCompletada(){
        return completada;
    }
    //Getter
}
