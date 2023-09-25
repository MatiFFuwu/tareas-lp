public class Pieza extends Zona implements ILevantar {
    private int peso;

    public Pieza(int peso){
        this.peso = peso;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public int getPeso(){
        return peso;
    }

    public void Levantar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if((cyan.getCantidad() * cyan.getCapacidad()) + (magenta.getCantidad() * magenta.getCapacidad()) + (amarillo.getCantidad() * amarillo.getCapacidad()) >= peso){
            System.out.println("¡Encontraste una pieza!");
            setCompletada(true);
        }
        else{
            System.out.println("Tus pikimin no pueden cargar la pieza todavía...");
        }
    }

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        Levantar(cyan, magenta, amarillo);
    }
}
