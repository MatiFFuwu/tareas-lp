public class Muralla extends Zona {
    private int vida;

    public Muralla(int vida){
        this.vida = vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getVida(){
        return vida;
    }

    public boolean TryRomper(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        vida = vida - ((cyan.getCantidad() * cyan.getAtaque()) + (magenta.getCantidad()*magenta.getAtaque()) + (amarillo.getCantidad()*amarillo.getAtaque()));
        if(vida<=0){
            return true;
        }
        else{
            System.out.println("Tus pikimin no han podido romper la muralla...");
            return false;
        }
    }

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if(TryRomper(cyan, magenta, amarillo)){
            setCompletada(true);
        }
    }
}
