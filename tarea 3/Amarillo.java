import java.lang.Math;

public class Amarillo extends Pikinim {
    public Amarillo(){
        super(1, 3, 10);
    }
    //Constructor

    public void multiplicar(int cantidad){
        setCantidad(getCantidad() + (int)(Math.ceil(cantidad*1.5)));
    }
    /************
     * Parametros: int
     * **********
     * Retorno: void
     * **********
     * Descripción: Recibe un entero cantidad y aumenta la cantidad de pikinims amarillos
     redondeando cantidad multiplicado por 1.5.
     ************
     */
}
