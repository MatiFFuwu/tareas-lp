import java.util.Scanner;

public class Pildora extends Zona {
    private int cantidad;

    private Scanner scan = new Scanner(System.in);

    public Pildora(int cantidad){
        this.cantidad = cantidad;
    }
    //Constructor

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    //Setter

    public int getCantidad(){
        return cantidad;
    }
    //Getter

    public String carac(){
        if(getCompletada()==true){
            return super.carac();
        }
        String carac = ", cantidad -> " + cantidad;
        return carac;
    }
    /************
     * Parametros: none
     * **********
     * Retorno: String
     * **********
     * Descripción: Entrega las características de alguna instancia de Pildora.
     ************
     */

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        if(getCompletada()==true){
            super.interactuar(cyan, magenta, amarillo);
            return;
        }
        int cant_pik = cyan.getCantidad() + magenta.getCantidad() + amarillo.getCantidad();
        System.out.println("Lomiar llegó a un lugar lleno de unas figuras con forma de píldoras, los " + cant_pik + " Pikinim se llevan las píldoras.");
        System.out.println("");
        System.out.println("----------------------------------------------------------");
        System.out.println("Qué color de Pikinim desea que se multiplique?");
        System.out.println("1.Cyan 2.Magenta 3.Amarillo");
        System.out.println("");
        System.out.print("Input: ");
        String eleccion = scan.nextLine();
        if(eleccion.equals("1")){
            cyan.multiplicar(cantidad);
            System.out.println("los Pikinim cyan han aumentado su cantidad en " + cyan.getCantidad());
            System.out.println("");
        }
        else if(eleccion.equals("2")){
            magenta.multiplicar(cantidad);
            System.out.println("los Pikinim magenta han aumentado su cantidad en " + magenta.getCantidad());
            System.out.println("");
        }
        else if(eleccion.equals("3")){
            amarillo.multiplicar(cantidad);
            System.out.println("los Pikinim amarillos han aumentado su cantidad en " + amarillo.getCantidad());
            System.out.println("");
        }
        setCompletada(true);
    }
    /************
     * Parametros: Pikinim
     * **********
     * Retorno: void
     * **********
     * Descripción: Llama multiplicar de 1 color de Pikinim que elige el 
     jugador, entregando cantidad como parámetro. Apenas termina esto se debe 
     declarar como completada.
     ************
     */
}
