/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Scanner;

public class AdmonJuego {

    public static NodoLista inicioL, finL; //punteros para saber donde esta el inicio y el fin
    public static NodoArbol raiz = null, p, nuevo, q, r, otro; //datos de tipo punteros
    int dato;
    static final int TAM_ARREGLO = 6;
    static int cola[] = new int[TAM_ARREGLO];
    static int d = 0;
    static String cola2[] = new String[TAM_ARREGLO];
    static String ds = null;
    int max = 5, frente = 0, fin = 0;
    int max2 = 5, frente2 = 0, fin2 = 0;

    //Metodo para asignar numero a las casillas 
    public void generarCasillas(int numeros[][], int TAM_ARREGLO) {
        int aux = 0, num = 35;
        for (int x = 0; x < TAM_ARREGLO; x++) {
            for (int y = 0; y < TAM_ARREGLO; y++) {
                if (y >= aux) {
                    numeros[x][y] = num--;
                } else {
                    numeros[x][y] = num--;
                }
            }
            aux++;
        }
        for (int x = 0; x < TAM_ARREGLO; x++) {
            for (int y = 0; y < TAM_ARREGLO; y++) {
                if (numeros[x][y] == 0) {
                    System.out.print("\u001B[41m" + " " + " [  " + numeros[x][y] + " ] " + " " + "\u001B[0m");
                } else {
                    if (numeros[x][y] == 35) {
                        System.out.print(" " + "\u001B[42m" + " [ " + numeros[x][y] + " ] " + "\u001B[0m" + " ");
                    } else {
                        if (numeros[x][y] <= 9) {
                            System.out.print(" " + " [  " + numeros[x][y] + " ] " + " ");
                        } else {
                            System.out.print(" " + " [ " + numeros[x][y] + " ] " + " ");
                        }
                    }
                }
            }
            System.out.println("");
        }
    }

    public void istruciones() {
        Scanner leer = new Scanner(System.in);
        char opc;
        int aux = 0;
        do {
            System.out.println("<> Para ganar el juego, el jugador tendra que llegar a la casilla final\n"
                    + "<> Al caer en una casilla con serpiente el jugador bajara a una posicion determinada.\n"
                    + "<> Al llegar a una casilla con escalera el jugador subirá a una posicion determinada.\n"
                    + "<> La casilla final se identifica con " + "\u001B[42m" + "00\n" + "\u001B[0m"
                    + "<> La casilla inicial se identifica con " + "\u001B[41m" + "00\n" + "\u001B[0m"
                    + "<> La serpiente se identifica con" + "\u001B[44m" + " $$\n" + "\u001B[0m"
                    + "<> La escalera se identifica con:" + "\u001B[43m" + " ##" + "\u001B[0m");
            System.out.println("¿Ya has visto las reglas? (S/N):");
            opc = leer.next().charAt(0);
            if (opc == 's' || opc == 'S') {
                aux = 1;
            } else {
                if (opc == 'n' || opc == 'N') {
                    aux = 0;
                } else {
                    System.out.println("ERROR ingrese la letra corespondiente [S/N]");
                }
            }
        } while (aux != 1);
    }

    //metodo para mover la cassilla de los jugadores
    public void moverCasilla(int dado, int numeros[][], int turno, int jugador1, int jugador2) {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (numeros[x][y] == 0) {
                    System.out.print("\u001B[41m" + " " + " [  " + numeros[x][y] + " ] " + " " + "\u001B[0m");
                } else {
                    if (numeros[x][y] == 35) {
                        System.out.print(" " + "\u001B[42m" + " [ " + numeros[x][y] + " ] " + "\u001B[0m" + " ");
                    } else {
                        if (numeros[x][y] == 31 || numeros[x][y] == 29 || numeros[x][y] == 20) {
                            System.out.print(" " + " [ " + numeros[x][y] + " ]" + "\u001B[44m" + "$" + "\u001B[0m" + " ");
                        } else {
                            if (numeros[x][y] == 2 || numeros[x][y] == 5 || numeros[x][y] == 13 || numeros[x][y] == 15) {
                                if (numeros[x][y] == 2 || numeros[x][y] == 5) {
                                    System.out.print(" " + " [  " + numeros[x][y] + " ]" + "\u001B[43m" + "#" + "\u001B[0m" + " ");
                                } else {
                                    System.out.print(" " + " [ " + numeros[x][y] + " ]" + "\u001B[43m" + "#" + "\u001B[0m" + " ");
                                }
                            } else {
                                if (numeros[x][y] == jugador1) {
                                    if (numeros[x][y] <= 9) {
                                        System.out.print(" " + " [  " + numeros[x][y] + " ]" + "\u001B[34m" + "J1" + "\u001B[0m");
                                    } else {
                                        System.out.print(" " + " [ " + numeros[x][y] + " ]" + "\u001B[34m" + "J1" + "\u001B[0m");
                                    }
                                } else {
                                    if (numeros[x][y] == jugador2) {
                                        if (numeros[x][y] <= 9) {
                                            System.out.print(" " + " [  " + numeros[x][y] + " ]" + "\u001B[31m" + "J2" + "\u001B[0m");
                                        } else {
                                            System.out.print(" " + " [ " + numeros[x][y] + " ]" + "\u001B[31m" + "J2" + "\u001B[0m");
                                        }
                                    } else {
                                        if (numeros[x][y] <= 9) {
                                            System.out.print(" " + " [  " + numeros[x][y] + " ] " + " ");
                                        } else {
                                            System.out.print(" " + " [ " + numeros[x][y] + " ] " + " ");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("");
        }
    }

    public int SerpienteEscalera(int jugador1, int jugador2, String nombreJugador1, int puntajeJugador1) {
        int contAE = 0;
        if (jugador1 == 31) {
            contAE = 26;
            System.out.println("Caiste en una serpiente");
            System.out.println("El jugador 1 " + nombreJugador1 + " Se mueve a la casilla:" + contAE);
            puntajeJugador1 = puntajeJugador1 + 5;
        } else {
            if (jugador2 == 31) {
                contAE = 26;
            } else {
                if (jugador1 == 29) {
                    contAE = 23;
                    System.out.println("Caiste en una serpiente");
                    System.out.println("El jugador 1 " + nombreJugador1 + " Se mueve a la casilla:" + contAE);
                    puntajeJugador1 = puntajeJugador1 + 6;
                } else {
                    if (jugador2 == 29) {
                        contAE = 23;
                    } else {
                        if (jugador1 == 20) {
                            contAE = 15;
                            System.out.println("Caiste en una serpiente");
                            System.out.println("El jugador 1 " + nombreJugador1 + " Se mueve a la casilla:" + contAE);
                            puntajeJugador1 = puntajeJugador1 + 5;
                        } else {
                            if (jugador2 == 20) {
                                contAE = 15;
                            } else {
                                if (jugador1 == 2) {
                                    contAE = 9;
                                    System.out.println("Caiste en una una escalera");
                                    System.out.println("El jugador 1 " + nombreJugador1 + " Se mueve a la casilla:" + contAE);
                                    puntajeJugador1 = puntajeJugador1 - 7;
                                } else {
                                    if (jugador2 == 2) {
                                        contAE = 9;
                                    } else {
                                        if (jugador1 == 5) {
                                            contAE = 17;
                                            System.out.println("Caiste en una escalera");
                                            System.out.println("El jugador 1 " + nombreJugador1 + " Se mueve a la casilla:" + contAE);
                                            puntajeJugador1 = puntajeJugador1 - 12;
                                        } else {
                                            if (jugador2 == 5) {
                                                contAE = 17;
                                            } else {
                                                if (jugador1 == 13) {
                                                    contAE = 25;
                                                    System.out.println("Caiste en una escalera");
                                                    System.out.println("El jugador 1 " + nombreJugador1 + " Se mueve a la casilla:" + contAE);
                                                    puntajeJugador1 = puntajeJugador1 - 12;
                                                } else {
                                                    if (jugador2 == 13) {
                                                        contAE = 25;
                                                    } else {
                                                        if (jugador1 == 15) {
                                                            contAE = 27;
                                                            System.out.println("Caiste en una escalera");
                                                            System.out.println("El jugador 1 " + nombreJugador1 + " Se mueve a la casilla:" + contAE);
                                                            puntajeJugador1 = puntajeJugador1 - 12;
                                                        } else {
                                                            if (jugador2 == 15) {
                                                                contAE = 27;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return contAE;
    }

    /*Almacenamos los puntajes de los jugadores 
      mediante la utilizacion de un atbol*/
    public void consulaPuntajes(int dato, int opcA) {
        if (raiz == null) {
            opcA = 1;
        }
        switch (opcA) {
            case 1:
                crearArbol(raiz, dato);
                break;
            case 2:
                insertarArbol(raiz, dato);
                break;
            case 3:
                preordenArbol(raiz);
                break;

        }
    }

    //metodo para crear arbol 
    public void crearArbol(NodoArbol p, int dato) {
        if (p == null) {
            nuevo = new NodoArbol(nuevo, dato);
            raiz = nuevo;

        } else {
            System.out.println("El arbol ya está creado");
        }

    }

    //metodo para insertar datos al arbol
    public void insertarArbol(NodoArbol p, int dato) {
        if (dato < p.info) {
            if (p.hi == null) {
                nuevo = new NodoArbol(nuevo, dato);
                p.hi = nuevo;

            } else {
                insertarArbol(p.hi, dato); //Llamada recursiva
            }
        } else {
            if (dato > p.info) {
                if (p.hd == null) {
                    nuevo = new NodoArbol(nuevo, dato);
                    p.hd = nuevo;
                } else {
                    insertarArbol(p.hd, dato); //Llamada recursiva 
                }
            } else {
                System.out.println("El nodo ya se encuentra en el árbol");
            }
        }
    }

    //metodo para imprimir los datos del arbol en preorden
    public void preordenArbol(NodoArbol p) {
        if (p != null) {
            System.out.print(" " + p.info + " Puntos");
            System.out.print("     ");
            preordenArbol(p.hi);
            preordenArbol(p.hd);
        }
    }

    /*Almacenamos los nombres de los jugadores en una lista*/
    public void consultaJugadores(String dato, int opcL) {
        switch (opcL) {
            case 1:
                agregarAlFInal(dato);
                break;
            case 2:

                break;
            case 3:
                mostrarLista();
                break;

        }
    }

    //Metodo para saber si una lista esta vacia 
    public boolean listaVacia() {
        if (inicioL == null) {
            return true; //si inicio es = null entoces la lista esta vaci­a 
        } else {
            return false; // si no entoces la lista tiene datos 
        }
    }

    //Metodo para agregar un elemento al final de la lista
    public void agregarAlFInal(String inf) {
        if (!listaVacia()) {
            finL.enlace = new NodoLista(inf); //si  no esta vacia (!)listaVacia entonces se agreaga informacion  
            finL = finL.enlace;
        } else {
            inicioL = finL = new NodoLista(inf); //si esta vacia entoces inicio y fin tomaran el valor de inf
        }
    }

    //Metodo para imprimir los elementos en la lista
    public void mostrarLista() {
        NodoLista recorrer = inicioL;
        while (recorrer != null) {
            if (recorrer.informacion.length() < 10) {
                System.out.print("[ " + recorrer.informacion + " ]");
                if (recorrer.informacion.length() == 9) {
                    System.out.print("  ");
                }
                if (recorrer.informacion.length() == 8) {
                    System.out.print("   ");
                }
                if (recorrer.informacion.length() == 7) {
                    System.out.print("    ");
                }
                if (recorrer.informacion.length() == 6) {
                    System.out.print("     ");
                }
                if (recorrer.informacion.length() == 5) {
                    System.out.print("      ");
                }
                if (recorrer.informacion.length() == 4) {
                    System.out.print("       ");
                }
                if (recorrer.informacion.length() == 3) {
                    System.out.print("        ");
                }
                if (recorrer.informacion.length() == 2) {
                    System.out.print("         ");
                }
                if (recorrer.informacion.length() == 1) {
                    System.out.print("          ");
                }
            }

            recorrer = recorrer.enlace;
        }
    }

    //Metodo para eliminar un elemento en la lista 
    public void eliminarElemento(String dato) {
        if (inicioL == finL && dato == inicioL.informacion) {
            inicioL = finL = null;
        } else {
            if (dato == inicioL.informacion) {
                inicioL = inicioL.enlace;
            } else {
                NodoLista anterior, temporal;
                anterior = inicioL;
                temporal = inicioL.enlace;
                while (temporal != null && temporal.informacion != dato) {
                    anterior = anterior.enlace;
                    temporal = temporal.enlace;
                }
                if (temporal != null) {
                    anterior.enlace = temporal.enlace;
                    if (temporal == finL) {
                        finL = anterior;
                    }
                }
            }
        }
    }

    //metodo para ordenar los mejores 5 puntajes del jugador1 
    public void quickSortRecursivo(int puntajes[], int n) {
        ordenarRecursivo(puntajes, 0, 99);
    }

    //mediante el metodo de ordenamiento quicksort ordenamos los puntajes del jugador 1
    public void ordenarRecursivo(int puntajes[], int izq, int der) {
        int i, j, v, aux;
        i = izq;
        j = der;
        v = puntajes[(i + j) / 2];
        do {
            while (puntajes[i] < v) {
                i++;
            }
            while (puntajes[j] > v) {
                j--;
            }
            if (i <= j) {
                aux = puntajes[i];
                puntajes[i] = puntajes[j];
                puntajes[j] = aux;
                i++;
                j--;
            }

        } while (i <= j);
        if (izq < j) {
            ordenarRecursivo(puntajes, izq, j);
            ordenarRecursivo(puntajes, i, der);
        }
    }

    //mediante busquedaBinaria se crea un metodo para buscar una casilla en especifico del tablero
    public void busquedaBinaria(int tableroMini[], int n, int dato) {
        int izq = 0, der, ban = 0, centro = 0;
        der = (n - 1);
        while (izq <= der && ban == 0) {
            centro = (izq + der) / 2;
            if (dato == tableroMini[centro]) {
                ban = 1;
            } else {
                if (dato > tableroMini[centro]) {
                    izq = centro + 1;
                } else {
                    der = centro - 1;
                }
            }
        }
        if (ban == 1) {
            //enviamos la informacion de la casilla al jugador
            if (tableroMini[centro] == 31) {
                System.out.println("La casilla coresponde a una serpiente");
                System.out.println("El jugador tendrá que volver a la casilla 26");
            } else {
                if (tableroMini[centro] == 29) {
                    System.out.println("La casilla coresponde a una serpiente");
                    System.out.println("El jugador tendrá que volver a la casilla 23");
                } else {
                    if (tableroMini[centro] == 20) {
                        System.out.println("La casilla coresponde a una serpiente");
                        System.out.println("El jugador tendrá que volver a la casilla 15");
                    } else {
                        if (tableroMini[centro] == 2) {
                            System.out.println("La casilla coresponde a una escalera");
                            System.out.println("El jugador tendrá que ir a la casilla 9");
                        } else {
                            if (tableroMini[centro] == 5) {
                                System.out.println("La casilla coresponde a una escalera");
                                System.out.println("El jugador tendrá que ir a la casilla 17");
                            } else {
                                if (tableroMini[centro] == 13) {
                                    System.out.println("La casilla coresponde a una escalera");
                                    System.out.println("El jugador tendrá que ir a la casilla 25");
                                } else {
                                    if (tableroMini[centro] == 15) {
                                        System.out.println("La casilla coresponde a una escalera");
                                        System.out.println("El jugador tendrá que ir a la casilla 27");
                                    } else {
                                        System.out.println("La casilla coresponde a una casilla normal");
                                        System.out.println("El jugador tendrá que mantenerse en la misma casilla que se le asignó");
                                    }

                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("ERROR: la casilla no se encuntra en el tablero");
        }
    }

}
