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
public class Pieza{
	private String id;
	private String color;
	private String descripcion;

        public Pieza(){
            
        }
	public Pieza(String id,String descripcion){
		this.id=id;
		this.descripcion=descripcion;
	}

    public String getId() {
        return id;
    }
    
    public int getNumber(){
        return Integer.parseInt(id.substring(1));
    }

	public String getColor(){
		return color;
	}

	public void setColor(String descripcion){
		this.color=color;
	}	
}