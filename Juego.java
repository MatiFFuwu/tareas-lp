public class Juego {
    public static void main(String[] args) {

        int cont_turnos = 1;
        int cont_piezas = 0;
        Cyan cyan = new Cyan();
        Magenta magenta = new Magenta();
        Amarillo amarillo = new Amarillo();
        Zona[] mapa = new Zona[11];

        Pieza myPieza0 = new Pieza(50);
        mapa[0] = myPieza0;
        Enemigo myEnemigo1 = new Enemigo(130,20,25);
        mapa[1] = myEnemigo1;
        Enemigo myEnemigo2 = new Enemigo(50,10,15);
        mapa[2] = myEnemigo2;
        Pildora myPildora3 = new Pildora(25);
        mapa[3] = myPildora3;
        Muralla myMuralla4 = new Muralla(50);
        mapa[4] = myMuralla4;
        Pieza myPieza5 = new Pieza(100);
        mapa[5] = myPieza5;
        Enemigo myEnemigo6 = new Enemigo(45, 8, 10);
        mapa[6] = myEnemigo6;
        Pieza myPieza7 = new Pieza(35);
        mapa[7] = myPieza7;
        Pildora myPildora8 = new Pildora(15);
        mapa[8] = myPildora8;
        Enemigo myEnemigo9 = new Enemigo(75, 15, 20);
        mapa[9] = myEnemigo9;
        Muralla myMuralla10 = new Muralla(150);
        mapa[10] = myMuralla10;

        System.out.println("BIENVENIDO A CAPTAIN LOMIAR'S ADVENTURE");
        System.out.println("=======================================");
        while(cont_turnos!=30){
            System.out.println("Turno " + cont_turnos);
            System.out.println("Pikinims: Cyan - " + cyan.getCantidad() + " ; Magenta - " + magenta.getCantidad() + " ; Amarillo - " + amarillo.getCantidad());
            System.out.println("¿Qué decisión deseas tomar?");
            if(cont_piezas==3){
                System.out.println("¡Encontraste todas las piezas! Arreglaste la nave y te fuiste.");
                break;
            }
            cont_turnos++;
        }
        System.out.println("Turno 30");
        if(cont_piezas!=3){
            System.out.println("No encontraste todas las piezas a tiempo, te ahogaste y moriste alrededor de tus pikimin.");
        }

    }
}

/* Tengo que agregar cuatro condicionales en donde detecte el tipo de zona
a la que va a entrar. De esa forma puedo hacer que dentro
del while vaya a la izquierda o derecha del arreglo.
Despues tengo que agregar los casos extra donde qué pasa si
va por fuera del arreglo, posicion - 1 o 11, ahi tengo que
hacer que se de la vuelta.

 */