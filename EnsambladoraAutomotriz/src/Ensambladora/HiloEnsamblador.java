/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensambladora;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bere
 */
public class HiloEnsamblador extends Thread{
    protected static int numProducto = 0;
    protected static int numHiloEnsamblador=1;
    protected int numPieza;
    ColaProduccion cp;
    ColaProductos cpf;
    private static String [] tipos = {"A","B","C","D"};


    public HiloEnsamblador( ColaProduccion cp, ColaProductos cpf) {
        super("E"+numHiloEnsamblador);
        this.cp = cp;
        this.cpf = cpf;
        numHiloEnsamblador++;
        numProducto++;
        numPieza=numProducto;
        

    }
    
    public void run() throws NullPointerException{
     ProductoFinal pf = new ProductoFinal(String.valueOf(numPieza));
     do{
         if(!cp.listaVacia()){
                     cp.sacaPieza(getName(),String.valueOf(numPieza),pf,cpf);
                 }else{
                 try {
                     sleep(100);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(HiloGeneradorPiezas.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
        if(pf.arrPiezas.size() == 4){
                 pf.listarPiezas();
                 cpf.insertarAlFinal(getName(),pf,numPieza);
                 numProducto++;
                 numPieza=numProducto;
                 pf = new ProductoFinal(String.valueOf(numPieza));
                 
             }
             
             
         }while(ColaProductos.numAutos < Prueba.tamanioBodega );
         
     }
        
}
