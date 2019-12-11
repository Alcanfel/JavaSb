package Task21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("После ввода данных и нажатия enter\nинформация записывается в файл log.txt");

        List<String> list = new ArrayList<>();
        list.add("Attenuator");
        list.add("Annihilator");
        list.add("Alcanfel");

        MyLog mylog = new MyLog("log.txt");
        Scanner sn = new Scanner(System.in);
        String input;

        do {
            input = sn.nextLine();
            String user = getUserRandom(list);
            mylog.logAdd(input, user);
            switch (input){
                case "getInfoUser":{

                }
                case "getInfoDate":{

                }
            }
        } while (!input.equals("exit"));

    }

    // Рандомно получаем пользователя из списка
    public static String getUserRandom(List<String> list){
        Integer integer = (int) (Math.random()*3);
        System.out.println(integer);
        return list.get(integer);
    }
}
