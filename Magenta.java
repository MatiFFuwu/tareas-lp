public class Magenta extends Pikinim {
    public Magenta(){
        super(2, 1, 10);
    }
    public void multiplicar(int cantidad){
        setCantidad(getCantidad() + cantidad * getAtaque());
    }

}