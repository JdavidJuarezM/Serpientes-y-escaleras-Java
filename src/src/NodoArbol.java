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
public class NodoArbol {

    public int info, fe;
    public NodoArbol hi, hd;

    NodoArbol(NodoArbol nuevo, int dato) {
        this.hi = null;
        this.hd = null;
        this.info = dato;

    }

}
