package Task21;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyLog {
    File file = null;
    public MyLog(){

    }
    public MyLog(String fileName) throws IOException {
        //Проверяем на существование файла
        if (Files.exists(Paths.get(fileName).toAbsolutePath())){
            System.out.println(String.format("Файл %s существует!", String.valueOf(Paths.get(fileName).toAbsolutePath())));
            this.file = new File(String.valueOf(Paths.get(fileName).toAbsolutePath()));
        } else {
            System.out.println(String.format("Файл %s не существует, создадим %s!", fileName,String.valueOf(Paths.get(fileName).toAbsolutePath())));
            this.file = new File(String.valueOf(Paths.get(fileName).toAbsolutePath()));
            this.file.createNewFile();
        }
    }

    // Метод добавления в файл записи
    public void logAdd(String sc, String user) throws IOException {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM:dd:yyyy HH:mm:ss");
        Files.write(Paths.get(String.valueOf(this.file)),formatForDateNow.format(dateNow).getBytes(), StandardOpenOption.APPEND); //Добавляем Дату
        Files.write(Paths.get(String.valueOf(this.file))," - ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(String.valueOf(this.file)),user.getBytes(), StandardOpenOption.APPEND); // Добавляем пользователя
        Files.write(Paths.get(String.valueOf(this.file))," - ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(String.valueOf(this.file)),sc.getBytes(), StandardOpenOption.APPEND); // Добавляем действие
        Files.write(Paths.get(String.valueOf(this.file)),"\n".getBytes(), StandardOpenOption.APPEND);

    }

    // Статический метод отображения действий по пользователю
    public static void printGroupUser(File file, String nameUser) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(String.valueOf(file)));
        Map<String, List<String>> map = new HashMap<>();
        for (String s: list
             ) {
            List<String> listValue = new ArrayList<>();
            if (!map.containsKey(s.split(" - ")[1])){
                listValue.add(s.split(" - ")[0] + " - " + s.split(" - ")[2]);
                map.put(s.split(" - ")[1], listValue);
            } else {
                List<String>listValueOld = map.get(s.split(" - ")[1]);
                listValueOld.add(s.split(" - ")[0] + " - " + s.split(" - ")[2]);
                map.put(s.split(" - ")[1], listValueOld);
            }
        }

            if (map.containsKey(nameUser)){
                System.out.println(String.format("Действия по пользователю %s:", nameUser));
                List<String> listUser = map.get(nameUser);
                for (String s: listUser
                     ) {
                    System.out.println(String.format("Дата %s - Действие %s", s.split(" - ")[0],s.split(" - ")[1]));
                }
            } else {
                System.out.println(String.format("В логе отсутствует пользователь %s",nameUser));
            }
    }
    // Статический метод отображения действий по дате
    public static void printGroupDate(File file) throws IOException, ParseException {
        List<String> list = Files.readAllLines(Paths.get(String.valueOf(file)));
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM:dd:yyyy HH:mm:ss");
        Map<String, List<String>> map = new HashMap<>();
        for (String s: list
             ) {
            Date date = new SimpleDateFormat("MM:dd:yyyy HH:mm:ss").parse(s.split(" - ")[0]);
            List<String> listValue = new ArrayList<>();
            if (!map.containsKey(formatForDateNow.format(date).split(" ")[0])){
                listValue.add(formatForDateNow.format(date).split(" ")[1] + " - " + s.split(" - ")[1] + " - " + s.split(" - ")[2]);
                map.put(formatForDateNow.format(date).split(" ")[0], listValue);
            } else {
                List<String>listValueOld = map.get(formatForDateNow.format(date).split(" ")[0]);
                listValueOld.add(formatForDateNow.format(date).split(" ")[1] + " - " + s.split(" - ")[1] + " - " + s.split(" - ")[2]);
                map.put(formatForDateNow.format(date).split(" ")[0], listValueOld);
            }
        }
        System.out.println("Действия пользователя в разрезе дня");
        for (String s: map.keySet()
             ) {
            System.out.println(String.format("День %s:", s));
            for (String ss: map.get(s)
                 ) {
                System.out.println(ss);
            }
            System.out.println();
        }

    }
}
