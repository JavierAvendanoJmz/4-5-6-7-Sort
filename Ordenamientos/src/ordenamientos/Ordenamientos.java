/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientos;
import Sort.*;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class Ordenamientos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista l = new Lista();
        l.agregar(new Nodo(5));
        l.agregar(new Nodo(8));
        l.agregar(new Nodo(2));
        l.agregar(new Nodo(1));
        l.agregar(new Nodo(6));
        l.agregar(new Nodo(7));
        l.agregar(new Nodo(4));
        l.agregar(new Nodo(9));
        l.agregar(new Nodo(3));        
        l.agregar(new Nodo(4));    
        System.out.println("Lista: "+l);
        Sort.quick(l);
        System.out.println("Ordenada: "+l);
    }
    
}
