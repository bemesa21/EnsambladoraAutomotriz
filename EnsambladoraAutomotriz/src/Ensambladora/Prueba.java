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
public class Prueba {
    
    public static void main(String[] args) {   
        ColaPiezas c = new ColaPiezas();
        ColaPiezas colaProduccion = new ColaPiezas();
        
        ArrayList<HiloGeneradorPiezas> arrHilosllenado = new ArrayList<HiloGeneradorPiezas>();
            arrHilosllenado.add(new HiloGeneradorPiezas("A",4,c));
            arrHilosllenado.add( new HiloGeneradorPiezas("B",4,c));
            arrHilosllenado.add( new HiloGeneradorPiezas("C",4,c));
                    
        for (HiloGeneradorPiezas h : arrHilosllenado) {
        	h.start();	
	}
	for (HiloGeneradorPiezas h : arrHilosllenado) {
            try{
                h.join();
		}catch(Exception e){
                    System.out.println("Algo sucedio al llenar las matrices");
		}
			
	}
        
                
        c.Listar();
    }
        
                

    }
    

