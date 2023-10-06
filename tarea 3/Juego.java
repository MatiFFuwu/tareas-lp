import java.util.Scanner;

public class Juego {
    static int cont_piezas = 0;
    public static void main(String[] args) {
        int cont_turnos = 1;
        int pos = 5;
        Cyan cyan = new Cyan();
        Magenta magenta = new Magenta();
        Amarillo amarillo = new Amarillo();
        Zona[] mapa = new Zona[11];
        Scanner scan = new Scanner(System.in);

        mapa[0] = new Pieza(50);
        mapa[1] = new Enemigo(130, 20, 25);
        mapa[2] = new Enemigo(50, 10, 15);
        mapa[3] = new Pildora(25);
        mapa[4] = new Muralla(50);
        mapa[5] = new Pieza(100);
        mapa[6] = new Enemigo(45,8,10);
        mapa[7] = new Pieza(35);
        mapa[8] = new Pildora(15);
        mapa[9] = new Enemigo(75,15,20);
        mapa[10] = new Muralla(150);

        System.out.println("");
        System.out.println("BIENVENIDO A CAPTAIN LOMIAR'S ADVENTURE");
        System.out.println("=======================================");
        while(cont_turnos!=30){
            System.out.println("----------------------------------------------------------");
            System.out.println("Posicion en el mapa: " + pos);
            System.out.println("--------------------->");
            System.out.println("Turno " + cont_turnos);
            System.out.println("");
            System.out.println("Cantidad de Piezas: " + cont_piezas);
            System.out.println("Pikinims: Cyan -> " + cyan.getCantidad() + " ; Magenta -> " + magenta.getCantidad() + " ; Amarillo -> " + amarillo.getCantidad());
            System.out.println("");
            System.out.println("¿Qué decisión deseas tomar?");
            if(pos==10){
                System.out.println("    1. Ir a la derecha (" + mapa[0].getClass().getSimpleName() + mapa[0].carac() + ")");
                System.out.println("    2. Ir a la izquierda (" + mapa[9].getClass().getSimpleName() + mapa[9].carac() + ")");
                System.out.println("    3. Quedarse aquí (" + mapa[pos].getClass().getSimpleName() + mapa[pos].carac() + ")");
                System.out.print("Eleccion >>> ");
                String eleccion = scan.nextLine();
                if(eleccion.equals("1")){
                    System.out.println("El capitan Lomiar se va a la derecha.");
                    System.out.println("----------------------------------------------------------");
                    pos = 0;
                }
                else if(eleccion.equals("2")){
                    System.out.println("El capitan Lomiar se va a la izquierda.");
                    System.out.println("----------------------------------------------------------");
                    pos = 9;
                }
                else if(eleccion.equals("3")){
                    System.out.println("El capitan Lomiar se queda en la misma posicion.");
                    System.out.println("----------------------------------------------------------");
                }
            }
            else if(pos==0){
                System.out.println("    1. Ir a la derecha (" + mapa[1].getClass().getSimpleName() + mapa[1].carac() + ")");
                System.out.println("    2. Ir a la izquierda (" + mapa[10].getClass().getSimpleName() + mapa[10].carac() + ")");
                System.out.println("    3. Quedarse aquí (" + mapa[pos].getClass().getSimpleName() + mapa[pos].carac() + ")");
                System.out.print("Eleccion >>> ");
                String eleccion = scan.nextLine();
                if(eleccion.equals("1")){
                    System.out.println("El capitan Lomiar se va a la derecha.");
                    System.out.println("----------------------------------------------------------");
                    pos = 1;
                }
                else if(eleccion.equals("2")){
                    System.out.println("El capitan Lomiar se va a la izquierda.");
                    System.out.println("----------------------------------------------------------");
                    pos = 10;
                }
                else if(eleccion.equals("3")){
                    System.out.println("El capitan Lomiar se queda en la misma posicion.");
                    System.out.println("----------------------------------------------------------");
                }
            }
            else{
                System.out.println("    1. Ir a la derecha (" + mapa[pos+1].getClass().getSimpleName() + mapa[pos+1].carac() + ")");
                System.out.println("    2. Ir a la izquierda (" + mapa[pos-1].getClass().getSimpleName() + mapa[pos-1].carac() + ")");
                System.out.println("    3. Quedarse aquí (" + mapa[pos].getClass().getSimpleName() + mapa[pos].carac() + ")");
                System.out.print("Eleccion >>> ");
                String eleccion = scan.nextLine();
                if(eleccion.equals("1")){
                    System.out.println("El capitan Lomiar se va a la derecha.");
                    System.out.println("----------------------------------------------------------");
                    pos = pos + 1;
                }
                else if(eleccion.equals("2")){
                    System.out.println("El capitan Lomiar se va a la izquierda.");
                    System.out.println("----------------------------------------------------------");
                    pos = pos - 1;
                }
                else if(eleccion.equals("3")){
                    System.out.println("El capitan Lomiar se queda en la misma posicion.");
                    System.out.println("----------------------------------------------------------");
                }
            }
            System.out.println("");
            mapa[pos].interactuar(cyan, magenta, amarillo);
            if(cyan.getCantidad()==0 && magenta.getCantidad()==0 && amarillo.getCantidad()==0){
                System.out.println("Todos tus pikinim han sido derrotados, nadie te salvará ahora...");
                break;
            }
            if(cont_piezas==3){
                System.out.println("¡Encontraste todas las piezas! Arreglaste la nave y te fuiste.");
                break;
            }
            cont_turnos++;
        }
        if(cont_piezas!=3 && cyan.getCantidad()!=0 && magenta.getCantidad()!=0 && amarillo.getCantidad()!=0){
            System.out.println("No encontraste todas las piezas a tiempo, te ahogaste y moriste alrededor de tus pikinim.");
        }
        scan.close();
    }
}
