/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.io.Serializable;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hassan Nawaz
 */
public class Queue_For_Jobs<T> implements Serializable{
    
        private Node<T> first;
        
	public Queue_For_Jobs()
	{
		first = null;
	}
	public void insertFirst(T x)
	{
		Node<T> n = new Node<>();
		n.setItem(x);
		n.setNext(first);
		first = n;
	}

	public void enqueue(T x)
	{
            
		if (first == null)
		{
			insertFirst(x);
		}
		else
		{
			Node<T> n = new Node<>();
			n.setItem(x);
			Node<T> temp = first;
			while (temp.getNext()!= null)
				temp = temp.getNext();
			n.setNext(temp.getNext());
			temp.setNext(n);
		}
	}

	public T dequeue()
	{
		if (first == null)
		{
			 
                         return null;
		}
		else
		{
			T ret = first.getItem();
			first = first.getNext();
			return ret;
		}
	}

	public T peek()
	{
		if (first == null)
		{
			
                        return null;
		}
		else
		{
			return first.getItem();
		}
	}
    
}
