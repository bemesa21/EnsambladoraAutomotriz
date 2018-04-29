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
public class ProductoFinal {
    protected static int numProducto = 0;
    protected int id;
    protected Pieza[] arrPiezas;

    public ProductoFinal() {
        arrPiezas= new Pieza[4];
        numProducto++;
        id=numProducto;
    }
    
    
}
