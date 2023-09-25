import java.util.Scanner;

public class Pildora extends Zona {
    private int cantidad;

    private Scanner scan = new Scanner(System.in);

    public Pildora(int cantidad){
        this.cantidad = cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void interactuar(Pikinim cyan, Pikinim magenta, Pikinim amarillo){
        int cant_pik = cyan.getCantidad() + magenta.getCantidad() + amarillo.getCantidad();
        System.out.println("Lomiar llegó a un lugar lleno de unas figuras con forma de píldoras, los " + cant_pik + " Pikinim se llevan las píldoras.");
        System.out.println("Qué color de Pikinim desea que se multiplique?");
        System.out.println("1.Cyan 2.Magenta 3.Amarillo");
        System.out.println("Input: ");
        String eleccion = scan.nextLine();
        if(eleccion == "1"){
            cyan.multiplicar(cantidad);
            System.out.println("los Pikinim cyan han aumentado su cantidad en " + cyan.getCantidad());
        }
        else if(eleccion == "2"){
            magenta.multiplicar(cantidad);
            System.out.println("los Pikinim magenta han aumentado su cantidad en " + magenta.getCantidad());
        }
        else if(eleccion == "3"){
            amarillo.multiplicar(cantidad);
            System.out.println("los Pikinim amarillos han aumentado su cantidad en " + amarillo.getCantidad());
        }
        setCompletada(true);
    }
}
