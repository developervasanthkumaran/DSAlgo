package stack;

import linklist.DoublyLinkList;

public class Stack<T> {
    private DoublyLinkList<T> dll;
    private int size;
    Stack(){
        dll =  new DoublyLinkList<>();
    }
    void add(T data){
        dll.addFirst(data);
        size++;
    }
    void push(T data){
        dll.addFirst(data);
        size++;
    }
    T peek(){
        return dll.getFirst();
    }
    T pop(){
        T val = dll.getFirst();
        dll.deleteFirst();
        size--;
        return val;
    }

    int getSize(){
        return size;
    }

    boolean isEmpty(){
        return size==0;
    }
    void print(){
        dll.printReverse();
    }
}
