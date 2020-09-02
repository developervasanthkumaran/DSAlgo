package tree;

public class BTree<T> {
    private int noOfNodes;
    private Node<T> root;

   public BTree(T r){
        root = new Node<>(r);
        this.noOfNodes = 0;
    }

   public void insertL(T leftOf,T data){
        Node<T> node = new Node<>(leftOf);
        insertL(root,node,data);
    }

    private void insertL(Node<T> root,Node<T> lOf,T data){
        if(root!=null){
            insertL(root.left,lOf,data);
            if(root.left == null && root.data.equals(lOf.data)){
                root.left = new Node<>(data);
                noOfNodes++;
            }
            insertL(root.right,lOf,data);
        }
    }
    private void insertR(Node<T> root,Node<T>  rOf,T data){
        if(root!=null){
            insertR(root.left,rOf,data);
            if(root.right ==null && root.data.equals(rOf.data)){
                root.right = new Node<>(data);
                noOfNodes++;
            }
            insertR(root.right,rOf,data);
        }
    }

    public void insertR(T rightOf,T data){
        Node<T> node = new Node<>(rightOf);
        insertR(root,node,data);
    }

    public void inOrderTraversal(){
       inOrderTraversal(root);
    }
    public void inOrderTraversal(Node<T> r){
        if(r!=null){
            inOrderTraversal(r.left);
            System.out.print(r.data+" ");
            inOrderTraversal(r.right);
        }
    }

    int height(Node parent, int c){
        if(parent!=null){
            int leftHeight = Math.max(height(parent.left,c+1),height(parent.right,c+1));
            System.out.println(leftHeight);

        }
        return c;
    }

    public Node<T> getRoot() {
        return root;
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }
}





