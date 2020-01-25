package Task23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    static Manufacturer manufacturer;
    static Consumer consumer;
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayList = new ArrayDeque<>();
        manufacturer = new Manufacturer(arrayList, 20);
        consumer = new Consumer(arrayList);
        Thread threadOne = new Thread(manufacturer);
        Thread threadTwo = new Thread(consumer);
        threadOne.start();
        threadTwo.start();

    }
}
