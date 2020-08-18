package tree;


public class AvlTree {
     private Node<Integer> root;


    private void setRoot(Node<Integer> root) {
        this.root = root;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    void insert(int data){
        setRoot(insert(root,data));
    }

    private Node<Integer> insert(Node<Integer> root,int data){
        if(root == null)return new Node<>(data);
        else if (data < root.data)
            root.left = insert(root.left,data);
        else if(data > root.data)
            root.right = insert(root.right,data);
        else return root;

        root.height = 1 + Math.max(height(root.left),height(root.right));
        int balance = getBalance(root);

        if(balance > 1 && data < root.left.data){
            return rightRotation(root);
        }
        if(balance < -1 && data > root.right.data){
            return leftRotation(root);
        }
        if(balance > 1 && data > root.left.data){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        if(balance < -1 && data < root.right.data){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }

    private int height(Node<Integer> root){
        if(root==null)return 0;
        return root.height;
    }

    private int getBalance(Node<Integer> root) {
        if (root == null) return 0;
        return height(root.left) - height(root.right);
    }
    private Node<Integer> rightRotation(Node<Integer> z){
        Node<Integer> node = z.left;
        Node<Integer> t3 = node.right;

        node.right = z;
        z.left = t3;

        node.height =Math.max(height(node.left),height(node.right))+1;
        z.height =Math.max(height(z.left),height(z.right))+1;

        return node;
    }
    private Node<Integer> leftRotation(Node<Integer> z){
        Node<Integer> node = z.right;
        Node<Integer> t3 = node.left;

        node.left = z;
        z.right = t3;

        node.height =Math.max(height(node.left),height(node.right))+1;
        z.height = Math.max(height(z.left),height(z.right))+1;

        return node;
    }
    void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node<Integer> root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }
    void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node<Integer> root){
        if(root!=null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
