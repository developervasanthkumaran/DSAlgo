package linklist;

public class DoublyLinkList<T>{
    private int size=0;
   private Node<T> head,tail,ptr;
    public DoublyLinkList(){
        String type = getClass().getGenericSuperclass().getTypeName();
        setDefaults(type);
    }

    void setDefaults(String type){
        Object h=null,t=null;
        switch (type) {
            case "Integer":
                h = Integer.MAX_VALUE;
                t = Integer.MIN_VALUE;
                break;
            case "Float":
                h = Float.MAX_VALUE;
                t = Float.MIN_VALUE;
                break;
            case "String":
                h = "head";
                t = "tail";
                break;
            case "Character":
                h = 'h';
                t = 't';
                break;
            case "Byte":
                h = Byte.MAX_VALUE;
                t = Byte.MIN_VALUE;
                break;
            case "Double":
                h = Double.MAX_VALUE;
                t = Double.MIN_VALUE;
                break;
            case "Long":
                h = Long.MAX_VALUE;
                t = Long.MIN_VALUE;
                break;
            case "Boolean":
                h = true;
                t = true;
                break;
        }

        head = new Node<>((T)h);
        tail = new Node<>((T)t);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

   public void add(T data){
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
   public void addFirst(T data){
        Node<T> node = new Node<>(data);
        Node<T> temp = head.next;
        head.next = node;
        node.prev= head;
        node.next = temp;
        temp.prev=node;
    }
   public void addLast(T data){
        add(data);
    }
  public   void delete(Node<T> node) {
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
   public void delete(int position) {
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
   public void deleteFirst(){
        if(head.next !=tail){
            head.next = head.next.next;
            head.next.prev = head;
            size--;
        }
    }
   public void deleteLast(){
        if(tail.prev!=null){
            tail.prev = tail.prev.prev;
            ptr = tail.prev;
            tail.next = null;
            ptr.next = tail;
            size--;
        }
    }
    int size(){return size;}
   public boolean contains(T data){
        Node<T> n = head.next;
        while (n!=null){
            if(n.data == data)return true;
            n=n.next;
        }
        return false;
    }

    public void print(){
        Node<T> n = head.next;
        while (n!=tail){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.println();
    }
    public void printReverse(){
        Node<T> n = tail.prev;
        while (n!=head){
            System.out.print(n.data+" ");
            n=n.prev;
        }
        System.out.println();
    }
    public T getFirst(){
        return head.next.data;
    }
    public T getLast(){
        return tail.prev.data;
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

