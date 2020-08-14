package tree;

public class Node<T> {
     Node<T> left,right;
     T data;
    Node(T data){
        this.data=data;
        this.right=left=null;
    }
}
