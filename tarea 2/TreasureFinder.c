#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"

int main(int argc, char const *argv[])
{
    // Su codigo
    int n;
    printf("¡Bienvenido a TreasureFinder!\n");
    printf("Indique el tamaño del tablero a jugar:\n");
    printf("1.7x7 2.10x10 3.12x12\n");
    scanf("%d",&n);
    printf("Su input: %d\n",n);
    return 0;
}

/* EJEMPLOS DE RANDOM PARA FACILITAR SU USO.
*
*   srand(time(0)); // Setea la seed del random.
*   int ejemplo_vida = (rand() % 3) + 1; // Obtiene al azar la vida de Tierra a asignar.
*/