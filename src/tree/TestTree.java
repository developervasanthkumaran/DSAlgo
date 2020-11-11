package tree;

public class TestTree {




    public static void main(String[] args) {
       BinaryTree<Integer> btree = new BinaryTree<>(1);
       btree.insertL(1,2);
       btree.insertR(1,3);
        btree.insertL(2,4);
        btree.insertR(2,5);
        btree.invertTree();
}}
