/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensambladora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author bere
 */
public class Prueba {
    private static String [] colores = {"rojo","verde","Azul","Gris"};
    protected static HashMap coloresAutos = new HashMap();
    protected static int tamanioBodega;

    public static void main(String[] args) {   
        Scanner teclado = new Scanner(System.in);
        int hp,he,tb,tp;
        ColaPiezas c = new ColaPiezas("Cola piezas");
        ColaProduccion colaProduccion = new ColaProduccion("Cola produccion");
        ColaProductos cp = new ColaProductos("Bodega");
        ArrayList<Thread> arrHilosllenado = new ArrayList<Thread>();
        asignarColores(50);
        
        System.out.println("¿Cuantos hilos pintores necesitas?");
        he = teclado.nextInt();
        System.out.println("Tiempo maximo de pintado");
        tp = teclado.nextInt();
        System.out.println("¿Cuantos hilos productores necesitas?");
        hp = teclado.nextInt();
        System.out.println("¿Cual es el tamanio de la bodega?");
        tamanioBodega = teclado.nextInt();

              arrHilosllenado.add(new HiloGeneradorPiezas("A",tamanioBodega,c));
            arrHilosllenado.add( new HiloGeneradorPiezas("B",tamanioBodega,c));
            arrHilosllenado.add( new HiloGeneradorPiezas("C",tamanioBodega,c));
            arrHilosllenado.add( new HiloGeneradorPiezas("D",tamanioBodega,c));
        for(int i = 0 ; i < hp ; i++){
                        arrHilosllenado.add(new HiloPintor(c,colaProduccion,tp));
        }
        for(int i = 0 ; i < he ; i++){
                        arrHilosllenado.add(new HiloEnsamblador(colaProduccion,cp));
        }
                           
        for (Thread h : arrHilosllenado) {
        	h.start();	
	}
	for (Thread h : arrHilosllenado) {
            try{
                h.join();
		}catch(Exception e){
                    System.out.println("No pude hacer un join");
		}	
	}
    }
    
    public static void asignarColores(int numAutos){
        for (int i = 0; i < numAutos; i++) {
            coloresAutos.put(i,colores[(int)(Math.random()*3)]);
        }
    }
    
    
    
    

    }
    

