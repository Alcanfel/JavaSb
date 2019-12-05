package MyQueue;

public interface LQueue<T> {
    void enqueue(T obj);

    T dequeue();
}
