/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensambladora;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bere
 */
public class HiloPintor extends Thread{
    ColaPiezas cp;
    ColaProduccion ce;
    private static int numHiloPintor = 1;
    private int tp;
    String color;

    public HiloPintor(ColaPiezas cp, ColaProduccion ce,int tp) {
        super("P"+numHiloPintor);
        this.cp=cp;
        this.ce=ce;
        this.tp=tp;
        numHiloPintor++;
    }
    
    public void run() throws NullPointerException{
        do{
            if(!cp.listaVacia()){
                Pieza aux = cp.sacarPieza(getName()).getNodoPieza();
                aux.setColor(String.valueOf(Prueba.coloresAutos.get(aux.getNumber())));
                ce.insertarAlFinal(getName(),aux);                
                try {
                sleep(tp);
                } catch (InterruptedException ex) {
                Logger.getLogger(HiloGeneradorPiezas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }while(!cp.listaVacia());
    }
    
    
}
