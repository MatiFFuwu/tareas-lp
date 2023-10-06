public abstract class Pikinim {
    private int ataque;
    private int capacidad;
    private int cantidad;

    public void disminuir(int cantidad){
        this.cantidad = this.cantidad - cantidad;
    };

    public abstract void multiplicar(int cantidad);
    /************
     * Parametros: cantidad
     * **********
     * Retorno: void
     * **********
     * Descripción: Declara el metodo multiplicar que deben implementar
     las clases cyan, magenta, amarillo.
     ************
     */

    public Pikinim(int ataque, int capacidad, int cantidad){
        this.ataque = ataque;
        this.capacidad = capacidad;
        this.cantidad = cantidad;
    }
    //Constructor

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    //Setter

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }
    //Setter

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    //Setter

    public int getAtaque(){
        return ataque;
    }
    //Getter

    public int getCapacidad(){
        return capacidad;
    }
    //Getter

    public int getCantidad(){
        return cantidad;
    }
    //Getter
}
