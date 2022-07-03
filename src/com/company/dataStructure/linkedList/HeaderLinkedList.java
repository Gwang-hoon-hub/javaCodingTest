package com.company.dataStructure;

public class HeaderLinkedList<T> {
    Node header;    // 헤더는 데이터가 없고 시작을 알리는 부분이다.
    static class Node<T> {
        T data;
        Node next = null;
    }

    public HeaderLinkedList(){
        header = new Node();
    }

    void append(T item){
        Node end = new Node();
        end.data = item;
        Node pointer = header;
        while(pointer.next != null)           // 다음 노드를 가리키는 포인터가 마지막 노드을 가리키도록 돌린다.
            pointer = pointer.next;
        pointer.next = end;                   // 마지막 노드를 가리키도록 한다.
    }

    void delete(T item){
        Node pointer = header;
        while (pointer.next != null){           // 다음 노드가 null 이면 현재가 마지막 노드 그렇지 않으면 남은 노드가 더 있다.
            if (pointer.next.data == item)      // 다음 노드의 데이터가 찾고자 하는 데이터와 같으면 -> 포인터로 찾는다.
                pointer.next = pointer.next.next;// 링크드리스트의 삭제는 포인터의 연결을 바꿔주는 것이다. 다음다음의 노드를 가리키도록한다.
            else pointer = pointer.next;        // 찾고자 하는 값이 아니면 현재의 포인터를 다음의 포인터로 옮겨준다.
        }
    }

    void retrieve(){
        Node pointer = header;
        while(pointer.next != null) {
            System.out.print(pointer.data + " -> ");
            pointer = pointer.next;
        }
        System.out.print(pointer.data);
    }

}
