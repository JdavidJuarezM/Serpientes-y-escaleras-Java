/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Scanner;

public class MenuDelJuego {

    public static void main(String args[]) {
        Scanner leer = new Scanner(System.in);
        final int TAM_ARREGLO = 6;
        int numeros[][] = new int[TAM_ARREGLO][TAM_ARREGLO];
        int puntajes[] = new int[100];
        int tableroMini[] = new int[35];
        int max = 0, numturno = 1;
        int px = 0;
        AdmonJuego juego = new AdmonJuego();
        int opc = 0, jugadores, opcpunt, opcinst;
        String opc1, opcJugadores, opcpuntajes, opcinstru, nombreJugador1 = null, nombreJugador2;
        char opcDado = 'n';
        int dado = 0, jugador1 = 0, jugador2 = 0, turno = 0, ban = 0, puntajeJugador1 = 0, puntajeJugador2;
        do {
            System.out.println(" ");
            System.out.println("\nSerpientes y escaleras");
            System.out.println("[1]JUGAR ");
            System.out.println("[2]INSTRUCCIONES");
            System.out.println("[3]Consular los resultados de los jugadores");
            System.out.println("[4]Salir");
            System.out.print("Opcion deseada? [1-4]: ");
            opc1 = leer.nextLine();

            opc = validaNum(opc1, 4);

            switch (opc) {
                case 1: //iniciar el juego 

                    System.out.println("\nIngrese el numero de jugadores \n [1] = un jugador \n [2] = Dos jugadores \n [3] = salir al menú");
                    System.out.print("Opcion deseada? [1-3]: ");
                    opcJugadores = leer.nextLine();
                    max = 3;
                    jugadores = validaNum(opcJugadores, max);
                    switch (jugadores) {
                        case 1: // jugador vs maquina
                            jugador1 = 0;
                            jugador2 = 0;
                            ban = 0;
                            puntajeJugador1 = 0;
                            System.out.println("\n\u001B[46m" + "\u001B[35m" + "<<<<Serpientes y Escaleras>>>" + "\u001B[0m");
                            juego.generarCasillas(numeros, TAM_ARREGLO);
                            System.out.println("Ingrese el Nombre del Jugador 1 : ");
                            nombreJugador1 = leer.nextLine();
                            do {
                                System.out.println("Jugdor 1 : " + nombreJugador1 + " ¿Tirar del dado?");
                                System.out.println("[S] = si  [N] = no");
                                opcDado = leer.next().charAt(0);
                                leer.nextLine();
                                if (opcDado == 'S' || opcDado == 's') {
                                    turno = 1;
                                } else {
                                    if (opcDado == 'N' || opcDado == 'n') {
                                        turno = 2;
                                    } else {
                                        turno = 3;
                                    }

                                }
                                switch (turno) {
                                    case 1:
                                        dado = (int) (Math.random() * 6);
                                        System.out.println("El dado dio el numero: " + dado);
                                        System.out.println("EL jugador 1 : " + nombreJugador1 + " se mueve:" + dado + " Casillas\n");
                                        jugador1 = jugador1 + dado;
                                        puntajeJugador1 = jugador1 + numturno;

                                        turno = 2;
                                        if (juego.SerpienteEscalera(jugador1, jugador2, nombreJugador1, puntajeJugador1) != 0) {
                                            jugador1 = juego.SerpienteEscalera(jugador1, jugador2, nombreJugador1, puntajeJugador1);
                                        }
                                        juego.moverCasilla(dado, numeros, turno, jugador1, jugador2);
                                        if (jugador1 >= 35) {
                                            break;
                                        }
                                    case 2:
                                        dado = (int) (Math.random() * 6);
                                        System.out.println("Es el turno de la maquina");
                                        System.out.println("El dado dio el numero: " + dado);
                                        System.out.println("EL Jugador 2 se mueve:" + dado + " Casillas\n");
                                        jugador2 = jugador2 + dado;
                                        turno = 1;
                                        if (juego.SerpienteEscalera(jugador1, jugador2, nombreJugador1, puntajeJugador1) != 0) {
                                            jugador2 = juego.SerpienteEscalera(jugador1, jugador2, nombreJugador1, puntajeJugador1);
                                        }
                                        juego.moverCasilla(dado, numeros, turno, jugador1, jugador2);
                                        break;
                                    default:
                                        System.out.println("ERROR: ingrese únicamente un carácter.");
                                        break;
                                }
                                if (jugador1 >= 35) {
                                    System.out.println("Felicidades el Jugador 1: " + nombreJugador1 + " ha ganado");
                                    System.out.println("!Gracias por jugar!");
                                    ban = 1;
                                    int casoL = 1, casoA = 2;
                                    juego.consultaJugadores(nombreJugador1, casoL);
                                    juego.consulaPuntajes(puntajeJugador1, casoA);
                                    puntajes[px] = puntajeJugador1;
                                    px++;
                                    numturno = numturno + 1;
                                } else {
                                    if (jugador2 >= 35) {
                                        System.out.println("Felicidades el Jugador 2 ha ganado");
                                        System.out.println("!Gracias por jugar!");
                                        ban = 1;
                                        int casoL = 1, casoA = 2;
                                        juego.consultaJugadores(nombreJugador1, casoL);
                                        juego.consulaPuntajes(puntajeJugador1, casoA);
                                        puntajes[px] = puntajeJugador1;
                                        px++;
                                        numturno = numturno + 1;
                                    }
                                }
                            } while (ban != 1);
                            break;
                        case 2: // jugador 1 vs jugador 2 
                            System.out.println("\nPROXIMAMENTE.");
                            break;
                        case 3: //salir del juego 
                            break;
                    }
                    break;
                case 2: //Instrucciones 
                    System.out.println("Elige la opcion incidada:");
                    System.out.println("[1] = Consultar las instrucciones del juego");
                    System.out.println("[2] = Buscar la informacion de cada casilla");
                    System.out.println("[3] = Salir");
                    System.out.println("¿Opcion deseada? [1-3]");
                    opcinstru = leer.nextLine();
                    opcinst = validaNum(opcinstru, 3);
                    switch (opcinst) {
                        case 1:
                            juego.istruciones();
                            break;
                        case 2:
                            int auxcasi = 0;
                            for (int x = 0; x < 35; x++) {
                                tableroMini[x] = auxcasi + 1;
                                auxcasi++;
                            }
                            int casilla;
                            int auxint = 0;
                            char opcvali;
                            try {
                                do {
                                    System.out.println("Ingrese la casilla a buscar: ");
                                    casilla = leer.nextInt();
                                    juego.busquedaBinaria(tableroMini, 35, casilla);
                                    leer.nextLine();
                                    System.out.println("¿Desea buscar otra casilla? (S/N):");
                                    opcvali = leer.next().charAt(0);
                                    leer.nextLine();
                                    if (opcvali == 's' || opcvali == 'S') {
                                        auxint = 1;
                                    } else {
                                        if (opcvali == 'n' || opcvali == 'N') {
                                            auxint = 2;
                                        } else {
                                            System.out.println("ERROR ingrese la letra corespondiente [S/N]");
                                            auxint = 2;
                                            leer.nextLine();
                                        }
                                    }
                                } while (auxint != 2);
                            } catch (Exception e) {
                                System.out.println("ERROR unicamente numeros");
                                leer.nextLine();
                            }
                            break;

                        case 3:
                            break;
                    }
                    break;
                case 3:
                    if (nombreJugador1 != null) {
                        System.out.println("Elige la opcion indicada:");
                        System.out.println("[1] = consultar el registro de todos los jugadores");
                        System.out.println("[2] = consultar los 5 mejores puntajes del jugador1");
                        System.out.println("[3] = salir");
                        System.out.println("¿Opcion deseada? [1-3]");
                        opcpuntajes = leer.nextLine();
                        opcpunt = validaNum(opcpuntajes, 3);
                        switch (opcpunt) {

                            case 1:
                                int casoL = 3,
                                 casoA = 3;
                                juego.consultaJugadores(nombreJugador1, casoL);
                                System.out.println(" ");
                                juego.consulaPuntajes(puntajeJugador1, casoA);
                                break;
                            case 2:
                                int auxsort = 0;
                                do {
                                    juego.quickSortRecursivo(puntajes, 5);
                                    auxsort = auxsort + 1;
                                } while (auxsort != 18);
                                //juego.quickSortRecursivo(puntajes, 5);
                                int contaux = 1;
                                for (int x = 99; x > 94; x--) {
                                    System.out.print("[" + puntajes[x] + "]\t\t");

                                }
                                System.out.println("");
                                for (int x = 0; x < 5; x++) {
                                    System.out.print("[" + contaux + " Lugar]\t");
                                    contaux++;
                                }
                                break;
                            case 3:
                                break;
                        }
                    } else {
                        System.out.println("Aun no se ha registrado ningún jugador");
                    }

                    break;
                case 4:
                    System.out.println("Gracias por jugar!");
                    System.out.println("Programa Finalizado");
                    break;
            }
        } while (opc != 4);
    }

    private static int validaNum(String numero, int max) {
        Scanner read = new Scanner(System.in);
        boolean res;
        int num = 0, s = 0;
        do {
            res = validacion(numero);
            if (res == true) {
                num = Integer.parseInt(numero);
                if (num <= 0 || num > max) {
                    System.out.println("ERROR..... Ingrese una opcion [1-" + max + "]");
                    numero = read.nextLine();
                } else {
                    System.out.println("OPCION CORRECTA\n");
                    s = 1;
                }
            } else {
                System.out.println("ERROR...SOLO NUMEROS....SELECCIONE UNA OPCIÓN DEL 1-" + max + " ");
                numero = read.nextLine();
            }
        } while (s == 0);

        return num;
    }

    private static boolean validacion(String numero) {

        try {
            int num = Integer.parseInt(numero);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
