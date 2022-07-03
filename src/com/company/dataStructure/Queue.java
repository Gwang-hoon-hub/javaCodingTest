package com.company.dataStructure;

import java.util.NoSuchElementException;

public class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    private void Enqueue(T item){
        Node<T> t = new Node<>(item);
        if(last != null)
            last.next = t;
        last = t;
        if(first != null)
            first = last;
    }

    private T Dequeue(){
        if(first == null){
            throw new RuntimeException();
        }
        T item = first.data;
        first = first.next;

        if (first == null){
            last = null;
        }
        return item;
    }

    private T Peek(){
        if(first == null)
            throw new RuntimeException();
        return first.data;
    }

    private boolean isEmpty(){
        return first == null;
    }

}
