package Task20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;


//        * - сделать возможность добавлять и хранить информацию в разрезе каждого дня.



public class Main {
    public static void main(String[] args) throws IOException {
        MyLog mylog = new MyLog("logging.txt"); // Создали объект логирования - файл logging.txt
        User user = new User("Aitov", "Artur", 1231313);

        while (true){ // в бесконечном цикле будем ожидать действия от пользователя, выйти из цикла цифра 3
            Scanner sc = new Scanner(System.in); //Поток ввода
            UserSign.showMenu(); // Выводим меню по регистрации и авторизации пользователя
            String i = sc.nextLine();
            mylog.logAdd(String.valueOf(i), user.toString());

            switch (i){
                case "1":{
                    UserSign.registration(sc);  //  Вызывается метод регистрации
                    break; // далее повторяем, переходим к след итерации
                }
                case "2":{
                    UserSign loginUser = UserSign.autorisation(sc);
                    if (loginUser.getLogin() == null){ // Авторизация
                        System.out.println("Login or Password unknown");
                        continue;
                    } else {
                        MainCar.showMenu(loginUser.getLogin());
                        String input;
                        // Путь к файлу хранится в энуме
                        //String dataFile = MyPathFile.DATACAR.getPathUbuntu();

                        do {
                            input = sc.nextLine();
                            mylog.logAdd(input, user.toString());
                            switch (input.split(" ")[0]) {
                                case "calc": {
                                    MainCar.calc(input);
                                    break;
                                }
                                case "add": {
                                    MainCar.add(input);
                                    break;
                                }
                                case "type": {
                                    MainCar.type(input);
                                    break;
                                }
                                case "exit": {
                                    System.out.println("- выход из программы");
                                    break;
                                }
                                default: {
                                    System.out.println(String.format("- команда %s отсутствует", input.split(" ")[0]));
                                }
                            }
                        } while (!input.equals("exit"));
                    }
                    break;
                }
                case "3":{
                    System.out.println("Пока!");
                    break;
                }
                default:{
                    System.out.println("Нужно выбрать 1, 2 или 3");
                    break;
                }

            }
        }
    }
}
