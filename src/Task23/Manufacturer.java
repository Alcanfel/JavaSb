package Task23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class Manufacturer implements Runnable {
    ArrayDeque<Integer> arrayList;
    Integer len;

    public Manufacturer(ArrayDeque<Integer> arrayList, Integer len){
        this.arrayList = arrayList;
        this.len = len;
    }
    @Override
    public void run() {
        while (true){
            if (this.arrayList.size() < this.len){
                Integer value = (int)(Math.random()*10);
                arrayList.offer(value);
                System.out.println(String.format("Добавлен %d", value));
            } else {
                System.out.println("Список полный");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
//            System.out.println(this.arrayList);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
