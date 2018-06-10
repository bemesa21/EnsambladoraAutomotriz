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
public class ColaProduccion {
      private String name;
   private NodoPieza head;
   private NodoPieza tail;         

    public ColaProduccion(String name) {
        this.name = name;
    }
  
   public boolean listaVacia() {
      return head == null;
   }
 
   public synchronized String getHeadColor(){
       return listaVacia() ? "" : head.getNodoPieza().getColor();
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
      System.out.println("El robot " + robot + "termina de pintar la pieza " + p.getId()+ " y entra en la seccion de ensamblaje");
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
      System.out.println("El robot de ensamble" + robot + " esta ensamblando la pieza " + aux.getNodoPieza().getId());

      notifyAll();
      return aux;
      
   }
		
   	//Metodo que elimina un nodo de la cola sin importar su posicion.
	public synchronized void sacaPieza(String robot, String name, ProductoFinal pf,ColaProductos cpf){
            
            Pieza paux= new Pieza();
		if (!listaVacia()) {
			if (head == tail && head.getNodoPieza().getId().contains(name)) {
				paux=head.getNodoPieza();
                                head = tail = null;
                                pf.insertarPieza(paux);
                                System.out.println("El robot de ensamble" + robot + " esta ensamblando la pieza " + paux.getId());
			}else if(head.getNodoPieza().getId().contains(name)){
                            	paux=head.getNodoPieza();
				head = head.GetSiguiente();
                                pf.insertarPieza(paux);
                                System.out.println("El robot de ensamble " + robot + " esta ensamblando la pieza " + paux.getId());
			}else{
				NodoPieza anterior, temp;
				anterior = head;
				temp = head.GetSiguiente();
				while(temp != null && !temp.getNodoPieza().getId().contains(name)){
					anterior = anterior.GetSiguiente();
					temp = temp.GetSiguiente();
				}
				if (temp != null) {
                                        paux = temp.getNodoPieza();
                                        pf.insertarPieza(paux);
                                        System.out.println("El robot de ensamble" + robot + " esta ensamblando la pieza " + paux.getId());
					anterior.SetSiguiente(temp.GetSiguiente());
					if (temp == tail) {
						tail = anterior;
					}
				}
                            

			}
                   
		}

                
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
