package queue;

import linklist.DoublyLinkList;

public class Queue<T> {
    private DoublyLinkList<T> dll;
    private int size;
    public Queue(){
        dll =  new DoublyLinkList<>();
    }
    public void add(T data){
        dll.add(data);
        size++;
    }
   public T peek(){
        return dll.getFirst();
    }
  public  T poll(){
        if(size==0)return null;
        T val = dll.getFirst();
        dll.deleteFirst();
        size--;
        return val;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        dll.print();
    }
}
