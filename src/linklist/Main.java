package LInkList;

public class Main {

    public static void main(String[] args) {
        DoublyLinkList<Integer> list = new DoublyLinkList<>(Integer.MAX_VALUE,Integer.MAX_VALUE);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.addFirst(6);
        list.print();
        list.addLast(7);
        list.print();
        list.deleteFirst();
        list.print();
        list.deleteLast();
        list.print();
        System.out.println(list.contains(10));
        list.printReverse();
    }

}
