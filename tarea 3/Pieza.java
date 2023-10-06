public class Pieza extends Zona implements ILevantar {
    private int peso;

    public Pieza(int peso){
        this.peso = peso;
    }
    //Constructor

    public void setPeso(int peso){
        this.peso = peso;
    }
    //Setter

    public int getPeso(){
        return peso;
    }
    //Getter

    public String carac(){
        if(getCompletada()==true){
            return super.carac();
        }
        String carac = ", peso -> " + peso;
        return carac;
    }
    /************
     * Parametros: none
     * **********
     * Retorno: String
     * **********
     * Descripción: Entrega las características de alguna instancia de Pieza.
     ************
     */

    public void Levantar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if((cyan.getCantidad() * cyan.getCapacidad()) + (magenta.getCantidad() * magenta.getCapacidad()) + (amarillo.getCantidad() * amarillo.getCapacidad()) >= peso){
            System.out.println("¡Encontraste una pieza!");
            System.out.println("");
            setCompletada(true);
            Juego.cont_piezas++;
        }
        else{
            System.out.println("Tus pikimin no pueden cargar la pieza todavía...");
            System.out.println("");
        }
    }
    /************
     * Parametros: Pikinim
     * **********
     * Retorno: void
     * **********
     * Descripción: Se lleva la pieza si la suma de cantidad * capacidad de los 3 colores 
     de Pikinim es mayor o igual que el peso de la pieza. Si es así, suma 1 al contador de piezas global.
     Hacer esto exitosamente deja completada la Zona.
     ************
     */

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if(getCompletada()==true){
            super.interactuar(cyan, magenta, amarillo);
            return;
        }
        Levantar(cyan, magenta, amarillo);
    }
    /************
     * Parametros: Pikinim
     * **********
     * Retorno: void
     * **********
     * Descripción: Levanta la pieza, a menos que ya esté completada la zona,
     donde en tal caso llama al interactuar de Zona.
     ************
     */
}
