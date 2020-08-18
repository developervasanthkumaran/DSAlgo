package tree;

public class Node<T> {
     Node<T> left,right;
     T data;
     int height;
    Node(T data){
        this.data=data;
        this.right=left=null;
        this.height = 1;
    }
}
