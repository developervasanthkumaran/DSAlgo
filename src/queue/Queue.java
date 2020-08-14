package queue;

import linklist.DoublyLinkList;

public class Queue<T> {
    private DoublyLinkList<T> dll;
    private int size;
    Queue(){
        dll =  new DoublyLinkList<>();
    }
    void add(T data){
        dll.add(data);
        size++;
    }
    T peek(){
        return dll.getFirst();
    }
    T poll(){
        T val = dll.getFirst();
        dll.deleteFirst();
        size--;
        return val;
    }

    int getSize(){
        return size;
    }
}
