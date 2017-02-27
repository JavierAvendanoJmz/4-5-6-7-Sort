/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author javier
 */
public class Lista {
    
    Nodo inicio;
    
    public Nodo get(int i) {
        Nodo aux = inicio;
        for (int j = 0; j < i; j++) 
            aux = aux.getSiguiente();
        return aux;
    }
    
    public int indexOf(Nodo n) {
        Nodo aux = inicio;
        int i = 0;
        while (aux!=null && aux!=n) {
            i++;
            aux = aux.getSiguiente();
        }
        if (aux != null)
            return i;
        else
            return -1;
    }
    
    public Nodo getFin(){
        if(inicio==null)
            return null;
        Nodo aux = inicio;
        while(aux.getSiguiente()!= null)           
            aux = aux.getSiguiente();
        return aux;
    }
    
    public void agregar(Nodo n){
        Nodo aux = inicio;
        Nodo ant = null;
        if(aux == null)
            inicio = n;
        else {
            while(aux!=null){
                ant = aux;
                aux = aux.getSiguiente();
            }
            ant.setSiguiente(n);
            n.setAnterior(ant);
        }
    }
    
    public String imprimirAlReves() {
        Nodo aux = inicio;
        String s = new String();
        while(aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        s += aux.getDato() + " ";
        while(aux != inicio) {
            aux = aux.getAnterior();
            s += aux.getDato() + " ";
        }
        return s;
    }
    
    @Override
    public String toString() {
        Nodo aux = inicio;
        String s = new String();
        while(aux != null) {
            s += aux.getDato() + " ";
            aux = aux.getSiguiente();
        }
        return s;
    }
    
    public boolean isEmpty() {
        if(inicio!=null)
            return false;
        else
            return true;
    }
    
    public int getSize() {        
        Nodo aux = inicio;
        int i = 0;
        while(aux != null) {
            i++;
            aux = aux.getSiguiente();            
        }
        return i;
    }
    
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }
    
    public Lista() {
    }        

    public Lista(Nodo inicio) {
        this.inicio = inicio;
    }    

}
