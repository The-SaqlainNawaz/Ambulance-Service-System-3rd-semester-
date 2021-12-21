/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

/**
 *
 * @author Hassan Nawaz
 */
public class Stack<T> {
    private Node<T> top;

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }
    
    Stack()
    {
        this.top=null;
    }
    
    public void push(T x)
    {
        Node<T> temp= new Node<>();
        
        if(temp==null){
            System.out.print("\nHeap overflow");
            return; 
        }    
        
        temp.setItem(x);
        temp.setNext(top);
        
        top=temp;
    }
    
    public boolean isempty()
    {
        return top==null;
    }
    
    public T peek()
    {
        if(!isempty())
        {
            return top.getItem();
        }
        else
        {
            System.out.print("Stack is empty");
            return null;
        }
    }
    public T pop()
    {
        if(top==null)
        {
            System.out.printf("\nStack underflow");
            return null;
        }
        else{
        Node<T> temp=top;
        top=(top).getNext();
        return temp.getItem();
        
                }
       
    }
   
    
}
