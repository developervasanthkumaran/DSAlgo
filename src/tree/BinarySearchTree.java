package tree;

public class BinarySearchTree {
    private int noOfNodes;
    private Node<Integer> root;
    BinarySearchTree(int data)  {
            root = new Node<>(data);
            noOfNodes = 0;
    }

    void insert(int data){
        insert(root,data);
    }

    Node<Integer> insert(Node<Integer> r,int data){
    if(r == null)return new Node<>(data);
    if(data < r.data)
        r.left = insert(r.left,data);
    else if(data > r.data)
        r.right = insert(r.right,data);
    else return r;
    return r;
    }
    public int getNoOfNodes() {
        return noOfNodes;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node<Integer> r){
        if(r!=null){
            inOrderTraversal(r.left);
            System.out.print(r.data+" ");
            inOrderTraversal(r.right);
        }
    }

}
