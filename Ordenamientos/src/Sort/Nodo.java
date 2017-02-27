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
public class Nodo {
    
    Integer dato;
    Nodo siguiente;
    Nodo anterior;

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo(Integer dato) {
        this.dato = dato;
    }    

    public Nodo() {
    }
    
}
