public class Magenta extends Pikinim {
    public Magenta(){
        super(2, 1, 10);
    }
    //Constructor

    public void multiplicar(int cantidad){
        setCantidad(getCantidad() + cantidad * getAtaque());
    }
    /************
     * Parametros: int
     * **********
     * Retorno: void
     * **********
     * Descripción: Recibe un entero cantidad y aumenta la cantidad de pikinims magenta
     multiplicando cantidad por su ataque.
     ************
     */
}
