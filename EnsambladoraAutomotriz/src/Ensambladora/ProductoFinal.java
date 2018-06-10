/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensambladora;

import java.util.ArrayList;

/**
 *
 * @author bere
 */
public class ProductoFinal {
    protected static int numProducto = 1;
    protected String id;
    protected ArrayList<Pieza> arrPiezas;

    public ProductoFinal(String id) {
        arrPiezas = new ArrayList<Pieza>();
        this.id=id;
        numProducto++;

    }

    public String getId() {
        return id;
    }
    
    public void insertarPieza(Pieza p){
        arrPiezas.add(p);
    }
    
    public void listarPiezas(){
        for(Pieza p : arrPiezas){
            System.out.print("["+p.getId() + "]  ");
        }
        System.out.println("\n");
    }
}
