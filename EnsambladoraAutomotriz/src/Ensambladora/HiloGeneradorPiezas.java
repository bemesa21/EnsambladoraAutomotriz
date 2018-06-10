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
public class HiloGeneradorPiezas extends Thread{
    private ColaPiezas cola;
    private int numPiezas;
    public HiloGeneradorPiezas(String name, int numPiezas, ColaPiezas cola) {
        super(name);
        this.numPiezas = numPiezas;
        this.cola = cola;
    }
    
    public void run(){
        
            String descripcion;
            int tiempoEspera=0;
            switch(getName().toCharArray()[0]){
                case 'A':
                    descripcion = "Puerta";
                    tiempoEspera=100;
                break;
                case 'B':
                        descripcion = "Cofre";
                        tiempoEspera=120;
                break;
                case 'C':
                    descripcion = "Chasis";
                    tiempoEspera=90;
                break;
                case 'D':
                    descripcion = "Cajuela";
                    tiempoEspera=110;
                break;
                default:
                    descripcion = " ";
                break;
            }
            for(int i = 1; i <= numPiezas; i++){
                cola.insertarAlFinal(getName(),new Pieza(getName()+i, descripcion));
            }
            try {
                sleep(tiempoEspera);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloGeneradorPiezas.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
        }
    
}
