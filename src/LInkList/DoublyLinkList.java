package LInkList;

 class DoublyLinkList<T> {
    private int size=0;
   private Node<T> head,tail,ptr;
    DoublyLinkList(T dHValue,T dTValue){
        head = new Node<>(dHValue);
        tail = new Node<>(dTValue);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    void add(T data){
        Node<T> node = new Node<>(data);
       if(ptr == null){
           head.next = node;
           node.prev= head;
           node.next = tail;
           tail.prev= node;
           ptr = node;
       }
       else {
           ptr.next = node;
           node.prev = ptr;
           node.next = tail;
           tail.prev = node;
           ptr = ptr.next;
       }
       size++;
    }
    void addFirst(T data){
        Node<T> node = new Node<>(data);
        Node<T> temp = head.next;
        head.next = node;
        node.prev= head;
        node.next = temp;
        temp.prev=node;
    }
    void addLast(T data){
        add(data);
    }
    void delete(Node<T> node) {
        Node<T> n = head.next;
        while (n != null){
            if(n.next.data == node.data){
                n.next = n.next.next;
                n.next.prev = n;
                size--;
                break;
            }
            n=n.next;
        }
    }
    void delete(int position) {
        Node<T> n = head.next;
        int c=0;
        while (n != null){
            if(position-1 == c){
                n.next = n.next.next;
                n.next.prev = n;
                size--;
            }
            else c++;
            n=n.next;
        }
    }
    void deleteFirst(){
        if(head.next !=tail){
            head.next = head.next.next;
            head.next.prev = head;
            size--;
        }
    }
    void deleteLast(){
        if(tail.prev!=null){
            tail.prev = tail.prev.prev;
            ptr = tail.prev;
            tail.next = null;
            ptr.next = tail;
            size--;
        }
    }
    int size(){return size;}
    boolean contains(T data){
        Node<T> n = head.next;
        while (n!=null){
            if(n.data == data)return true;
            n=n.next;
        }
        return false;
    }

    void print(){
        Node<T> n = head.next;
        while (n!=tail){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.println();
    }
    void printReverse(){
        Node<T> n = tail.prev;
        while (n!=head){
            System.out.print(n.data+" ");
            n=n.prev;
        }
        System.out.println();
    }
}


class Node<T>{
    Node<T> prev, next;
    T data;
    Node(T data){
        this.data=data;
        this.prev = next =null;
    }
}