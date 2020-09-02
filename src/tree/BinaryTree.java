package tree;

public class BinaryTree<T> {
    private int noOfNodes;
    private Node<T> root;

   public BinaryTree(T r){
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
    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    public void preOrderTraversal(Node<T> r){
        if(r!=null){
            System.out.print(r.data+" ");
            preOrderTraversal(r.left);
            preOrderTraversal(r.right);
        }
    }
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    public void postOrderTraversal(Node<T> r){
        if(r!=null){
            postOrderTraversal(r.left);
            postOrderTraversal(r.right);
            System.out.print(r.data+" ");
        }
    }

    int height(Node<T> parent, int c){
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





