/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author David
 */
public class NodoLista {

    public String informacion;
    public NodoLista enlace;

    //constructor para insertar al final 
    NodoLista(String inf) {
        this.informacion = inf;
        this.enlace = null;
    }

}
