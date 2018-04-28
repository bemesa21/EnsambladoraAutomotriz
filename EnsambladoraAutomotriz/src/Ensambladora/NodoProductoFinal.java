/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensambladora;

/**
 *
 * @author bere
 */
public class NodoProductoFinal {
    ProductoFinal producto;
    NodoProductoFinal siguiente;

    public NodoProductoFinal(ProductoFinal producto) {
        this.producto = producto;
        siguiente = null;
    }

    public void setSiguiente(NodoProductoFinal siguiente) {
        this.siguiente = siguiente;
    }

    public NodoProductoFinal getSiguiente() {
        return siguiente;
    }
    
    
    
    
}
