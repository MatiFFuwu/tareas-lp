public abstract class Pikinim {
    private int ataque;
    private int capacidad;
    private int cantidad;

    public void disminuir(int cantidad){
        this.cantidad = this.cantidad - cantidad;
    };
    public abstract void multiplicar(int cantidad);

    //Constructor
    public Pikinim(int ataque, int capacidad, int cantidad){
        this.ataque = ataque;
        this.capacidad = capacidad;
        this.cantidad = cantidad;
    }

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public int getAtaque(){
        return ataque;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public int getCantidad(){
        return cantidad;
    }
}
