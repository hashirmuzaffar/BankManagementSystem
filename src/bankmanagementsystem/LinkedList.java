/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author madih
 */
class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data){
        this.data = data;
    }
}

public class LinkedList<T extends Comparable<T>> {

    Node<T> head;
    int count = 0;

    //O(N)    
        public void insert(T object) {
        Node newNode = new Node(object);
        if(head == null){
            count++;
            head = newNode;
        }
        else{
            count++;
            newNode.next = head;
            head = newNode;
        }

    }
    //O(N)
    public String toString() {
        Node<T> temp = head;
        String concatenate = "";
        while (temp.next != null) {
            concatenate += temp.data + ", ";
            temp = temp.next;
        }
        if (temp.next == null) {
            concatenate += temp.data + "";
        }
        return concatenate;
    }
    
    public ArrayList<T> getAllNodes(){
        ArrayList<T> listOfNodes = new ArrayList<T>();
        Node<T> temp = head;
        String concatenate = "";
        while (temp != null) {
            listOfNodes.add(temp.data);
            temp = temp.next;
        }
        return listOfNodes;
    }

    //O(N)
    public boolean find(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.compareTo(data) == 0) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //O(1)
    public void clear() {
        head = null;
        count = 0;
    }

    //O(1)
    public int length() {
        return count;
    }

    //O(1)
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    //O(N)
    public void remove(T data) {
        Node<T> temp = head;
        Node<T> tempPrev = null;
        while (temp != null && (data.compareTo(temp.data) == 0)) {
            tempPrev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value not found");
        } else if (temp == head) {
            head = head.next;
        } else {
            tempPrev.next = temp.next;
        }
        count--;
    }
}