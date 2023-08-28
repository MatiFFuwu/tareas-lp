#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"
#include <stdlib.h>

void*** tablero;
int dimension;

void IniciarTablero(int n){
    Tierra terra;
    tablero = (void***)malloc(dimension * sizeof(tablero));
    for(int i=0;i<dimension;i++){
        tablero[i] = (void**)malloc(dimension * sizeof(tablero));
    }
    for(int i = 0;i < dimension; i++){
        for(int j = 0; j < dimension; j++){
            tablero[i][j] = (int*)malloc(sizeof(Tierra));
        }
    }
    return;
    /*srand(time(0)); // Setea la seed del random.
    int ejemplo_vida = (rand() % 3) + 1; // Obtiene al azar la vida de Tierra a asignar.*/
}


void PasarTurno(){
    // Su codigo
    return;
}


void ColocarBomba(Bomba* b, int fila, int columna){
    // Su codigo
    return;
}


void MostrarTablero(){
    // Su codigo
    return;
}


void MostrarBombas(){
    // Su codigo
    return;
}


void VerTesoros(){
    // Su codigo
    return;
}


void BorrarTablero(){
    for(int i = 0; i < dimension; i++){
        for(int j = 0; j < dimension; j++){
            free(tablero[i][j]);
        }
    }
    return;
}