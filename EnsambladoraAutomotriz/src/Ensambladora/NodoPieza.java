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
class NodoPieza {
    private Pieza nodoPieza;
	private NodoPieza siguiente;

    public NodoPieza(Pieza nodoPieza) {
        this.nodoPieza = nodoPieza;
        siguiente = null;
    }
	
	
    public NodoPieza GetSiguiente() {
        return siguiente;
    }
	
    public void SetSiguiente(NodoPieza siguiente) {
	this.siguiente = siguiente;
    }
	 
}