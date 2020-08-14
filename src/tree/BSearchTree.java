package tree;

public class BSearchTree {
    private int noOfNodes;
    private Node<Integer> root;
    BSearchTree(int data)  {
            root = new Node<>(data);
            noOfNodes = 0;
    }

    void insert(int data){
        insert(root,data);
    }

    void insert(Node<Integer> r,int data){
        if(r!=null){
            if(data < r.data){
                if(r.left == null)
                {r.left = new Node<>(data);
                noOfNodes++;
                }
                else insert(r.left,data);
            }else insert(r.right,data);

             if(data > r.data ){
                 if(r.right==null){
                r.right = new Node<>(data);noOfNodes++;
                 }
                 else insert(r.right,data);
            }else  insert(r.left,data);

        }
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
