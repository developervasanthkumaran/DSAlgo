package tree;

public class Main {
    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);
        avlTree.preOrder();
}}
