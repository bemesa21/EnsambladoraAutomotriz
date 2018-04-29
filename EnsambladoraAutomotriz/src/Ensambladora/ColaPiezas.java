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
class ColaPiezas {
   
   private NodoPieza head;
   private NodoPieza tail;         
  
   public boolean ListaVacia() {
      return head == null;
   }
 

   public synchronized void InsertarAlFinal(Pieza p){
      NodoPieza n = new NodoPieza(p);
   
      if (tail == null)
         head=tail= n;
      else{
         tail.SetSiguiente(n);
         tail=n;
      }
      notifyAll();
   }

	
   public synchronized NodoPieza Borrar() {
      NodoPieza aux =head;
      if (head==null)
         System.out.println("\nLista vacia....");
      else if (head == tail)
         head=tail=null;
      else 
         head = head.GetSiguiente();
      notifyAll();
      return aux;
      
   }
		
		
   public void Listar()
   {
      System.out.println("\n");
      NodoPieza q = head;
      while (q != null){
         System.out.print(q.getNodoPieza().getIdPieza() + " ");
         q = q.GetSiguiente() ;
      }
      System.out.println("\n");
   }
}

