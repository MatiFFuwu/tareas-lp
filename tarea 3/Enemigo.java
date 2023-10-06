import java.util.Random;
import java.util.Scanner;

public class Enemigo extends Zona implements ILevantar{
    private int vida;
    private int peso;
    private int ataque;
    private Scanner scan = new Scanner(System.in);
    private Random num = new Random();
    private int eleccion_enem;

    public Enemigo(int vida, int peso, int ataque){
        this.vida = vida;
        this.peso = peso;
        this.ataque = ataque;
    }
    //Constructor

    public void setVida(int vida){
        this.vida = vida;
    }
    //Setter

    public void setPeso(int peso){
        this.peso = peso;
    }
    //Setter

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    //Setter

    public void setNum(Random num){
        this.num = num;
    }
    //Setter

    public int getVida(){
        return vida;
    }
    //Getter

    public int getPeso(){
        return peso;
    }
    //Getter

    public int getAtaque(){
        return ataque;
    }
    //Getter

    public String carac(){
        if(getCompletada()==true){
            return super.carac();
        }
        String carac = ", vida -> " + vida + ", ataque -> " + ataque + ", peso -> " + peso;
        return carac;
    }
    /************
     * Parametros: none
     * **********
     * Retorno: String
     * **********
     * Descripción: Entrega las características de alguna instancia de Enemigo.
     ************
     */

    public void Levantar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if((cyan.getCantidad() * cyan.getCapacidad()) + (magenta.getCantidad() * magenta.getCapacidad()) + (amarillo.getCantidad() * amarillo.getCapacidad()) >= peso){
            System.out.println("¡Tus Pikinim han levantado exitosamente al enemigo!");
            System.out.println("");
            System.out.println("Qué color de Pikinim desea que se multiplique?");
            System.out.println("1.Cyan 2.Magenta 3.Amarillo");
            System.out.print("Input: ");
            String eleccion = scan.nextLine();
            System.out.println("");
            if(eleccion.equals("1")){
                cyan.multiplicar(peso);
                System.out.println("los Pikinim cyan han aumentado su cantidad en " + cyan.getCantidad());
                System.out.println("");
            }
            else if(eleccion.equals("2")){
                magenta.multiplicar(peso);
                System.out.println("los Pikinim magenta han aumentado su cantidad en " + magenta.getCantidad());
                System.out.println("");
            }
            else if(eleccion.equals("3")){
                amarillo.multiplicar(peso);
                System.out.println("los Pikinim amarillos han aumentado su cantidad en " + amarillo.getCantidad());
                System.out.println("");
            }
        }
        else{
            System.out.println("Tus pikinim no pudieron levantar al enemigo...");
            System.out.println("");
        }
    }

    /************
     * Parametros: Pikinim
     * **********
     * Retorno: void
     * **********
     * Descripción: Se lleva al enemigo si la suma de cantidad * capacidad de los 3 
     colores de Pikinim es mayor o igual que el peso del enemigo, si es así, debe 
     multiplicar 1 color de Pikinim en peso.
     ************
     */

    public boolean Pelear(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        eleccion_enem = num.nextInt(3) + 1;
        if(cyan.getCantidad()==0){
            eleccion_enem = num.nextInt(2) + 2;
        }
        if(magenta.getCantidad()==0){
            eleccion_enem = 2*num.nextInt(2) + 1;
        }
        if(amarillo.getCantidad()==0){
            eleccion_enem = num.nextInt(2) + 1;
        }
        if(magenta.getCantidad()==0 && amarillo.getCantidad()==0){
            eleccion_enem = 1;
        }
        if(cyan.getCantidad()==0 && amarillo.getCantidad()==0){
            eleccion_enem = 2;
        }
        if(cyan.getCantidad()==0 && magenta.getCantidad()==0){
            eleccion_enem = 3;
        }
        vida = vida - ((cyan.getCantidad() * cyan.getAtaque()) + (magenta.getCantidad()*magenta.getAtaque()) + (amarillo.getCantidad()*amarillo.getAtaque()));
        if(eleccion_enem == 1){
            System.out.println("¡El enemigo atacó a tus pikinim cyan! Disminuyendolos en " + ataque);
            cyan.setCantidad(cyan.getCantidad() - ataque);
            if(cyan.getCantidad()<0){
                cyan.setCantidad(0);
                
            }
        }
        else if(eleccion_enem == 2){
            System.out.println("¡El enemigo atacó a tus pikinim magenta! Disminuyendolos en " + ataque);
            magenta.setCantidad(magenta.getCantidad() - ataque);
            if(magenta.getCantidad()<0){
                magenta.setCantidad(0);
            }
        }
        else if(eleccion_enem == 3){
            System.out.println("¡El enemigo atacó a tus pikinim amarillos! Disminuyendolos en " + ataque);
            amarillo.setCantidad(amarillo.getCantidad() - ataque);
            if(amarillo.getCantidad()<0){
                amarillo.setCantidad(0);
            }
        }
        if(vida<=0){
            System.out.println("¡Tus Pikimin han derrotado al enemigo!");
            Levantar(cyan,magenta,amarillo);
            return true;
        }
        else{
            System.out.println("Tus Pikimin no han podido derrotar al enemigo...");
            System.out.println("");
            return false;
        }
    }
    /************
     * Parametros: Pikinim
     * **********
     * Retorno: void
     * **********
     * Descripción: Resta de su vida la suma de cantidad * ataque de los Pikinim, luego de 
     esto, el enemigo ataca a los Pikinim (sin importar si su vida llegó a 0), reduciendo 
     en ataque la cantidad de 1 color al azar. Si su vida llegó a 0, intenta levantarlo 
     inmediatamente.
     ************
     */

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if(getCompletada()==true){
            super.interactuar(cyan, magenta, amarillo);
            return;
        }
        if(Pelear(cyan,magenta,amarillo)){
            setCompletada(true);
        }
    }
    /************
     * Parametros: Pikinim
     * **********
     * Retorno: void
     * **********
     * Descripción: Realiza una pelea entre los Pikinim y el enemigo. Si
     el enemigo es derrotado, queda completada la Zona.
     ************
     */
}
