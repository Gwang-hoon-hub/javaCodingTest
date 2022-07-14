package com.company.dataStructure.linkedList;

class Node<T> {
    private T data;
    private Node<T> next = null;

    public Node(T data) {
        this.data = data;
    }

    void append(T item){
        Node<T> end = new Node<>(item); // 추가할 데이터의 노드를 생성
        Node<T> pointer = this;               // 현재 노드를 가리키는 포인터를 만든다.
        while(pointer.next != null)           // 다음 노드를 가리키는 포인터가 마지막 노드을 가리키도록 돌린다.
            pointer = pointer.next;
        pointer.next = end;                   // 마지막 노드를 가리키도록 한다.
    }

    // 자바에서 링크드리스트의 값을 삭제한다는 것은 노드의 연결을 끊는것이다.
    // 실제 데이터의 삭제는 GB(Garbage collector) 가 알아서 삭제한다.
    void delete(T item){
        // 첫번째 노드는 삭제를 하지 못한다.
        // head를 삭제하지 못하는 경우는 양방향 연결리스트를 사용한다.
        Node<T> pointer = this;
        while (pointer.next != null){           // 다음 노드가 null 이면 현재가 마지막 노드 그렇지 않으면 남은 노드가 더 있다.
            if (pointer.next.data == item)      // 다음 노드의 데이터가 찾고자 하는 데이터와 같으면 -> 포인터로 찾는다.
                pointer.next = pointer.next.next;// 링크드리스트의 삭제는 포인터의 연결을 바꿔주는 것이다. 다음다음의 노드를 가리키도록한다.
            else pointer = pointer.next;        // 찾고자 하는 값이 아니면 현재의 포인터를 다음의 포인터로 옮겨준다.
        }
    }

    void retrieve(){
        Node<T> pointer = this;
        while(pointer.next != null) {
            System.out.print(pointer.data + " -> ");
            pointer = pointer.next;
        }
        System.out.print(pointer.data);
    }
}

public class SinglyLinkedList<T> {
    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
    }
}
