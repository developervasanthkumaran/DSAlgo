package queue;

public class TestQueue {


    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.print();
        System.out.println("polled "+q.poll());
        q.print();
        System.out.println("polled "+q.poll());
        q.print();
        System.out.println("polled "+q.poll());
        q.print();
        System.out.println("polled "+q.poll());
        q.print();
        q.add(5);
        q.print();

    }
}
