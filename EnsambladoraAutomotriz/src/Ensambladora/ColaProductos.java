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
public class ColaProductos {

   private String name;
   private NodoProductoFinal head;
   private NodoProductoFinal tail;
   protected static int numAutos = 0;
  
    public ColaProductos(String name) {
        this.name = name;
    }

   public boolean listaVacia() {
      return head == null;
   }
 
   public synchronized String getHeadName(){
       return listaVacia() ? "" : head.getProducto().getId();
   }
           
   public synchronized void insertarAlFinal(String robot, ProductoFinal p, int numAuto){
      NodoProductoFinal n = new NodoProductoFinal(p);
   
      if (tail == null)
         head=tail= n;
      else{
         tail.setSiguiente(n);
         tail=n;
      }
      System.out.println("El robot " + robot + " termino el auto " + numAuto);
      System.out.println("\n"+name);
      listar();
      numAutos++;
      
      notifyAll();
   }
		
   public void listar()
   {
      System.out.print("\n-->");
      NodoProductoFinal q = head;
      while (q != null){
         System.out.print(q.getProducto().getId());
         q.getProducto().listarPiezas();
         q = q.getSiguiente() ;
      }
      System.out.println("<--\n");
   }
}

