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
public class Linked_List<T> implements Serializable{

    private int size = 0;
    private Node<T> head;

    public int getSize() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void insertFirst(T item) {
        Node<T> node = new Node<>();
        node.setItem(item);
        node.setNext(this.head);
        this.head = node;
        this.size++;
    }

    public void insertNode(T item) {
        Node<T> node = new Node<>();
        node.setItem(item);
        Node<T> current = this.head;

        if (this.head == null) {
            this.head = node;
            this.head.setNext(null);
            this.size = 1;
            
        } else {

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setNext(null);
            this.size += 1;
        }
    }
    public void replaceNode(T item,int index) {
        Node<T> node = new Node<>();
        node.setItem(item);
        Node<T> current = this.head;
        Node<T> previous=null;
        if (index!=0 ) {
            for (int i=0;i<index;i++) {
                    previous=current;
                    current=current.getNext();
                    break;
            }
                
                current.setItem(item);
                previous.setNext(current);
            }
         else if(this.head.getNext()!=null){
             node.setNext(head.getNext());
           this.head=node;
        }
         else if(this.head==null)
         {
             this.head=node;
         }
    }

    public void insertNth(T item) {
        Node<T> node = new Node<>();
        node.setItem(item);
        Node<T> current = this.head;
        if (this.head != null ) {
            for (;current!=null;) {
                if(current.getItem().equals(item))
                {
                    current=node;
                    break;
                }
                current = current.getNext();
            }
        } else {
            System.out.println("Exceeded the linked list size. Current Size: " + size);
        }
    }

    public void deleteNthNode(T key) {
        Node<T> currentNode = this.head;
        Node<T> prevNode = null;
        if (currentNode != null && currentNode.getItem() == key) {
            head = currentNode.getNext();
            return;
        }
        while (currentNode != null && currentNode.getItem() != key) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            return;
        }

        prevNode.setNext(currentNode.getNext());

    }

    public T findNodeAt(int location) {
        Node<T> node = this.head;
        if (head != null && location <= size) {
            for (int i = 0; i < location; i++) {
                node = node.getNext();
            }

        }
        return node.getItem();
    }

}
