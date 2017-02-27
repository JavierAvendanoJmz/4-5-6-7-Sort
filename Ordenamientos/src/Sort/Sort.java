/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class Sort {
    
    private static Nodo iteraQ(Nodo x, Nodo y) {
        boolean f = true;
        while( x != y) { 
            if (f) {
                if(x.getDato() > y.getDato()) {
                    Integer aux = x.getDato();
                    x.setDato(y.getDato());
                    y.setDato(aux);
                    f = false;
                    x = x.getSiguiente();
                } else {
                    y = y.getAnterior();
                }
            } else {
                if(y.getDato() < x.getDato()) {
                    Integer aux = x.getDato();
                    x.setDato(y.getDato());
                    y.setDato(aux);
                    f = true;
                    y = y.getAnterior();
                } else {
                    x = x.getSiguiente();
                }
            }
        }
        return x;
    }

    private static void divideQ(Lista l,ArrayList[] piv, Nodo aux, Integer[] divisiones, int i) {        
        if(aux.getAnterior()!=null) {
            int j = i-1;                       
            while(divisiones[j]!=1) 
                j--; 
            if(j != i-1) {
                piv[0].add(l.get(j));
                divisiones[i-1] = 1;
                piv[1].add(l.get(i-1)); 
            }
        }
        if(aux.getSiguiente()!=null) {
            int j = i+1;
            while(divisiones[j]!= 1)
                j++;
            if(j != i+1){
                piv[0].add(l.get(i+1));
                divisiones[i+1] = 1;
                piv[1].add(l.get(j));
            }
        }
    }
    
    public static void quick(Lista lista) {
        int s = lista.getSize();
        Integer[] divisiones = new Integer[s];
        for (int i = 0; i < s; i++) 
            divisiones[i] = 0;      
        ArrayList piv[] = new ArrayList[2];
        piv[0] = new ArrayList();
        piv[1] = new ArrayList();
        if(s > 0) {
            divisiones[0] = 1;
            divisiones[s-1] = 1;
            piv[0].add(lista.getInicio());
            piv[1].add(lista.getFin()); 
        }
        while(!piv[0].isEmpty()) {
            Nodo x = (Nodo)piv[0].get(0);
            Nodo y = (Nodo)piv[1].get(0);                       
            Nodo aux = iteraQ(x,y);
            divideQ(lista,piv,aux,divisiones,lista.indexOf(aux));          
            piv[0].remove(0);
            piv[1].remove(0);
        }
    }
    
    public static void shell(Lista lista ) {
        int t = lista.getSize(); 
        int piv = t/2;
        Nodo i = lista.getInicio();
        Nodo j = lista.getInicio();
        for (int k = 0; j!=null && k < piv; k++) {
            j = j.getSiguiente();
        }
        while(piv >= 1) {
            while(j != null) {
                Nodo aux = i;
                Nodo aux2 = j;
                while(aux != null && aux.getDato()>aux2.getDato()) {
                    Integer k = aux.getDato();
                    aux.setDato(aux2.getDato());
                    aux2.setDato(k);
                    k = 0;
                    aux2 = aux;
                    while(aux!= null && k < piv) {
                        aux = aux.getAnterior();
                        k++;
                    }
                }
                i = i.getSiguiente();
                j = j.getSiguiente();
            }
            piv /= 2;
            i = lista.getInicio();
            j = lista.getInicio();
            for (int k = 0; j!=null && k < piv; k++) {
                j = j.getSiguiente();
            }            
        }
    }
    
    public static void radix(Lista lista) {
        Nodo nodo = lista.getInicio();
        boolean f = true;
        int vuelta = 1;
        while(nodo!=null && f) {
            Lista l = new Lista();
            Lista[] r = new Lista[10];
            for (int i = 0; i < 10; i++)
                r[i] = new Lista();
            f = false;
            while(nodo!=null) {
                int aux = nodo.getDato();   
                int mod = 0;
                for (int i = 0; i < vuelta; i++) {
                    if(aux != 0) {
                        mod = aux % 10;   
                        aux /= 10;    
                        if (i== vuelta-1)
                            f = true;
                    }                                  
                    else
                        mod = 0;
                }
                r[mod].agregar(new Nodo(nodo.getDato()));
                nodo = nodo.getSiguiente();
            }
            for (int i = 0; i < 10; i++) {
                Nodo aux = r[i].getInicio();
                while(aux!=null){
                    l.agregar(new Nodo(aux.getDato()));
                    aux = aux.getSiguiente();
                }
            }            
            lista.setInicio(null);
            Nodo aux = l.getInicio();
            while(aux!=null) {
                lista.agregar(new Nodo(aux.getDato()));
                aux = aux.getSiguiente();
            }
            nodo = lista.getInicio();
            vuelta++;
        }
    }
    
    public static void burbuja(Lista l) {
        Nodo i = l.getInicio();
        Nodo j;
        while (i!= null && i.getSiguiente() != null) {
            j = i.getSiguiente();
            while (j != null) {
                if(i.getDato() > j.getDato()) {
                    Integer aux = i.getDato();
                    i.setDato(j.getDato());
                    j.setDato(aux);
                }
                j = j.getSiguiente();
            }
            i = i.getSiguiente();
        }
    }
    
}
