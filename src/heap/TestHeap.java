package heap;

public class TestHeap {
    public static void main(String[] args) {
        MinHeap m = new MinHeap(10);

        m.add(4);
        m.add(5);
        m.add(2);
        m.add(1);
        m.add(-2);
        m.add(17);
        m.showHeapItems();
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
    }
}
