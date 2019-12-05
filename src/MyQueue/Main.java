package MyQueue;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();
        myQueue.enqueue(10);
        myQueue.enqueue(30);
        myQueue.enqueue(40);
        myQueue.enqueue(50);
        myQueue.print();
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        myQueue.print();

    }
}
