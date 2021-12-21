/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.io.Serializable;

/**
 *
 * @author Hassan Nawaz
 */
public class Node<T> implements Serializable{
    private T item;
    private Node<T> next;

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    
    
}
