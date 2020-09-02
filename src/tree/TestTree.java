package tree;

public class TestTree {
    public static void main(String[] args) {
       BinaryTree<Character> btree = new BinaryTree<>('A');
       btree.insertL('A','B');
     btree.insertL('B','C');
     btree.insertL('C','D');
     btree.insertL('D','E');
     btree.insertR('D','F');
     btree.insertR('B','G');
     btree.insertR('G','H');
     btree.insertL('H','I');
     btree.insertR('A','J');
     btree.insertR('J','K');
     btree.insertL('K','L');
     btree.insertR('L','M');
        btree.preOrderTraversal();
        System.out.println();
        btree.postOrderTraversal();
        System.out.println();
        btree.inOrderTraversal();

}}
