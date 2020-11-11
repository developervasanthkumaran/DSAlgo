package heap;

public class TestHeap {
    public static void main(String[] args) {
        MaxHeap m = new MaxHeap(5);
        m.add(4);
        m.add(7);
        m.add(-1);
        m.add(8);
        m.pop();
        m.showHeapItems();
    }
}
