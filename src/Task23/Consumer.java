package Task23;

import java.util.ArrayDeque;
import java.util.Collection;

public class Consumer implements Runnable {
    ArrayDeque<Integer> arrayList;
    public Consumer(ArrayDeque<Integer> arrayList){
        this.arrayList = arrayList;
    }
    @Override
    public void run() {
        while (true){
            if (this.arrayList.size() > 0){
                System.out.println(String.format("Достали %d", this.arrayList.poll()));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("В списке нет значений");
            }
        }
    }
}
