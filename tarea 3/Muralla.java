public class Muralla extends Zona {
    private int vida;

    public Muralla(int vida){
        this.vida = vida;
    }
    //Constructor

    public void setVida(int vida){
        this.vida = vida;
    }
    //Setter

    public int getVida(){
        return vida;
    }
    //Getter

    public String carac(){
        if(getCompletada()==true){
            return super.carac();
        }
        String carac = ", vida -> " + vida;
        return carac;
    }

    /************
     * Parametros: none
     * **********
     * Retorno: String
     * **********
     * Descripción: Entrega las características de alguna instancia de Muralla.
     ************
     */

    public boolean TryRomper(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        vida = vida - ((cyan.getCantidad() * cyan.getAtaque()) + (magenta.getCantidad()*magenta.getAtaque()) + (amarillo.getCantidad()*amarillo.getAtaque()));
        if(vida<=0){
            System.out.println("Tus pikinim han roto la muralla!");
            System.out.println("");
            return true;
        }
        else{
            System.out.println("Tus pikimin no han podido romper la muralla...");
            System.out.println("");
            return false;
        }
    }
    /************
     * Parametros: Pikinim
     * **********
     * Retorno: boolean
     * **********
     * Descripción: Resta de vida de Muralla la suma de cantidad * ataque de los Pikinim.
     * Si es menor o igual a cero, se rompe y retorna true, caso contrario, retorna false.
     ************
     */

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if(getCompletada()==true){
            super.interactuar(cyan, magenta, amarillo);
            return;
        }
        if(TryRomper(cyan, magenta, amarillo)){
            setCompletada(true);
        }
    }
    /************
     * Parametros: Pikinim
     * **********
     * Retorno: void
     * **********
     * Descripción: Intenta romper la Muralla, si lo logra, queda completada
     la Zona.
     ************
     */
}
