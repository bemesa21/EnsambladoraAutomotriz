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
   private String name;
   private NodoPieza head;
   private NodoPieza tail;         
   
    public ColaPiezas(String name) {
        this.name = name;
    }
  
   public boolean listaVacia() {
      return head == null;
   }
 
   public synchronized String getHeadId(){
       return listaVacia() ? "" : head.getNodoPieza().getId();
   }
           
   public synchronized void insertarAlFinal(String robot, Pieza p){
      NodoPieza n = new NodoPieza(p);
   
      if (tail == null)
         head=tail= n;
      else{
         tail.SetSiguiente(n);
         tail=n;
      }
       System.out.println("El robot " + robot + " termino la pieza "  + p.getId() );
       System.out.println(name);
       listar();
      
      notifyAll();
   }

	
   public synchronized NodoPieza sacarPieza(String robot) {
      NodoPieza aux =head;
      if (listaVacia())
         return null;
      else if (head == tail)
         head=tail=null;
      else 
         head = head.GetSiguiente();
      System.out.println("El robot " + robot + " envia a la seccion de pintado la pieza " + aux.getNodoPieza().getId());
      notifyAll();
      return aux;
      
   }
		
		
   public synchronized void listar()
   {
      System.out.print("\n-->");
      NodoPieza q = head;
      while (q != null){
         System.out.print(q.getNodoPieza().getId()+ " ");
         q = q.GetSiguiente() ;
      }
      System.out.println("<--\n");
      notifyAll();
   }
}

