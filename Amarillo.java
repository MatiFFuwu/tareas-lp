import java.lang.Math;

public class Amarillo extends Pikinim {
    public Amarillo(){
        super(1, 3, 10);
    }
    public void multiplicar(int cantidad){
        setCantidad(getCantidad() + (int)(Math.ceil(cantidad*1.5)));
    }

}