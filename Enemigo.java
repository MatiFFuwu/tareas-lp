import java.util.Random;
import java.util.Scanner;

public class Enemigo extends Zona implements ILevantar{
    private int vida;
    private int peso;
    private int ataque;
    private Scanner scan = new Scanner(System.in);
    private Random num = new Random();
    private int eleccion_enem = num.nextInt(3) + 1;

    public Enemigo(int vida, int peso, int ataque){
        this.vida = vida;
        this.peso = peso;
        this.ataque = ataque;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }

    public int getVida(){
        return vida;
    }

    public int getPeso(){
        return peso;
    }

    public int getAtaque(){
        return ataque;
    }


    public void Levantar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if((cyan.getCantidad() * cyan.getCapacidad()) + (magenta.getCantidad() * magenta.getCapacidad()) + (amarillo.getCantidad() * amarillo.getCapacidad()) >= peso){
            System.out.println("¡Tus Pikinim han levantado exitosamente al enemigo!");
            System.out.println("Qué color de Pikinim desea que se multiplique?");
            System.out.println("1.Cyan 2.Magenta 3.Amarillo");
            System.out.println("Input: ");
            String eleccion = scan.nextLine();
            if(eleccion == "1"){
                cyan.multiplicar(peso);
                System.out.println("los Pikinim cyan han aumentado su cantidad en " + cyan.getCantidad());
            }
            else if(eleccion == "2"){
                magenta.multiplicar(peso);
                System.out.println("los Pikinim magenta han aumentado su cantidad en " + magenta.getCantidad());
            }
            else if(eleccion == "3"){
                amarillo.multiplicar(peso);
                System.out.println("los Pikinim amarillos han aumentado su cantidad en " + amarillo.getCantidad());
            }
        }
    }

    public boolean Pelear(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        vida = vida - ((cyan.getCantidad() * cyan.getAtaque()) + (magenta.getCantidad()*magenta.getAtaque()) + (amarillo.getCantidad()*amarillo.getAtaque()));
        if(eleccion_enem == 1){
            cyan.setCantidad(cyan.getCantidad() - ataque);
        }
        else if(eleccion_enem == 2){
            magenta.setCantidad(magenta.getCantidad() - ataque);
        }
        else if(eleccion_enem == 3){
            amarillo.setCantidad(amarillo.getCantidad() - ataque);
        }
        if(vida<=0){
            System.out.println("¡Tus Pikimin han derrotado al enemigo!");
            Levantar(cyan,magenta,amarillo);
            return true;
        }
        else{
            System.out.println("Tus Pikimin no han podido derrotar al enemigo...");
            return false;
        }
    }

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if(Pelear(cyan,magenta,amarillo)){
            setCompletada(true);
        }
    }
}