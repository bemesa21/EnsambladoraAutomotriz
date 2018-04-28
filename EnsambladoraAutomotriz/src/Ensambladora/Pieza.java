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

	public Pieza(String id, String color, String descripcion){
		this.id=id;
		this.color=color;
		this.descripcion=descripcion;
	}

	public String getIdPieza(){
		return id;
	}

	public void setidPieza(String id){
		this.id=id;
	}

	public String getColor(){
		return color;
	}

	public void setColor(String descripcion){
		this.color=color;
	}

	public String getDescripcion(){
		return descripcion;
	}

	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}

	
}