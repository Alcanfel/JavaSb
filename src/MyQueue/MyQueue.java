package MyQueue;

import java.util.Arrays;

public class MyQueue<T> implements LQueue<T> {
    T[] n;

    MyQueue(){
        this.n = null;
    }
    MyQueue(T[] arr){
        this.n = arr;
    }

    @Override
    public void enqueue(T elem) {
        if (this.n == null){
            this.n = (T[]) new Object[1];
            this.n[0] = elem;
        } else {
            T[] newN = (T[]) new Object[this.n.length+1];
            for (int i = 0; i < this.n.length ; i++) {
                newN[i+1] = this.n[i];
            }
            newN[0] = elem;
            this.n = newN;
        }
    }

    @Override
    public T dequeue() {
        T elem;
        if (this.n == null){
            return null;
        } else {
            T[] newN = (T[]) new Object[this.n.length-1];
            elem = this.n[this.n.length-1];
            for (int i = 0; i < this.n.length-1 ; i++) {
                newN[i] = this.n[i];
            }
            this.n = newN;
        }

        return elem;

    }

    public void print(){
        System.out.println(Arrays.toString(this.n));
    }
}
