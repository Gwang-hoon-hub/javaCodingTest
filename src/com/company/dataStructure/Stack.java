package com.company.dataStructure;



public class Stack<T> {
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public T pop(){
        if(top == null){
            throw new RuntimeException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        Node<T> t = new Node<>(item); // item 이 들어있는 노드를 하나 만든다.
        t.next = top;
        top = t;
    }

    public T peek(){
        if(top == null)
            throw new RuntimeException();
        return top.data;
    }

    public static void main(String[] args) {

    }
}
