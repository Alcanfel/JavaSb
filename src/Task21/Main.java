package Task21;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("После ввода данных и нажатия enter\nинформация записывается в файл log.txt");


        // Список пользователей
        List<String> list = new ArrayList<>();
        list.add("Attenuator");
        list.add("Annihilator");
        list.add("Alcanfel");

        // Создаем объект логирования, будем все записывать в файл log.txt
        MyLog mylog = new MyLog("log.txt");
        Scanner sn = new Scanner(System.in);
        String input;

        do {
            input = sn.nextLine(); // Будет операцией пользваотеля
            String user = getUserRandom(list); // Получаем пользваотеля из списка произвольно
            mylog.logAdd(input, user); // Вызываем метод ДОБАВИТЬ объекта логирования и передаем операцию и пользваотеля
        } while (!input.equals("exit"));

        //Отобразить действия по пользователю
        MyLog.printGroupUser(mylog.file, "Attenuator");
        System.out.println();
        MyLog.printGroupUser(mylog.file, "Alcanfel");
        System.out.println();
        MyLog.printGroupUser(mylog.file, "Annihilatorr");

//        Отобразить действия в разрезе дня
        MyLog.printGroupDate(mylog.file);

    }

    // Рандомно получаем пользователя из списка
    public static String getUserRandom(List<String> list){
        Integer integer = (int) (Math.random()*3);
        return list.get(integer);
    }
}
