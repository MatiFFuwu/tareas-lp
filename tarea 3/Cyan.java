public class Cyan extends Pikinim {

    public Cyan(){
        super(1, 1, 10);
    }
    //Constructor

    public void multiplicar(int cantidad){
        setCantidad(getCantidad() + cantidad * 3);
    }
    /************
     * Parametros: int
     * **********
     * Retorno: void
     * **********
     * Descripción: Recibe un entero cantidad y aumenta la cantidad de pikinims cyan
     multiplicando cantidad por 3.
     ************
     */

}
