package tree;

public class Main {
    public static void main(String[] args) {
       BSearchTree bSearchTree = new BSearchTree(3);
       bSearchTree.insert(1);
        bSearchTree.insert(5);
        bSearchTree.insert(6);
        bSearchTree.insert(2);
       bSearchTree.inOrderTraversal();
    }
}
