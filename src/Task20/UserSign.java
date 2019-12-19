package Task20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Scanner;

// Авторизация и регистрация пользователя

public class UserSign implements IUserSign {
    private String login;
    private String password;

    public UserSign(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public static UserSign autorisation(Scanner sc) throws IOException {
        MyLog mylog = new MyLog("logging.txt");
        Map<String, String> mapUser = Complete.getDictFileUser(); // словарь c пользваотелями
        System.out.print("Введите логин: ");
        String login = sc.nextLine();
        mylog.logAdd(login, login);
        if (!mapUser.containsKey(login)) {
            System.out.println("Логин отсутствует в системе");
            return null;
        } else {
            System.out.print("Введите пароль: ");
            String password = sc.nextLine();
            mylog.logAdd(password, login);
            if (mapUser.get(login).equals(password)) {
                return new UserSign(login, password);

            } else {
                System.out.println("Пароль введен неверно");
                return null;
            }
        }
    }


    public static void registration(Scanner sc) throws IOException {
        MyLog mylog = new MyLog("logging.txt");
        Map<String, String> user = Complete.getDictFileUser(); // словарь для пользователя (Логин-пароль)
        while (true) { // Бескоечный цикл, где выход это обязательная регистрация или если логин уже имеется в файле
            System.out.print("Введите логин: ");
            String login = sc.nextLine();
            mylog.logAdd(login, "noname");
            if (!user.containsKey(login)) { // Проверяем на наличие логина в файле, если есть идем дальше, нет выходим в главное регистрации и авторизации
                if (login.length() < 8) {  //  Проверяем длину
                    System.out.println("Логин должен быть больше 7 символов");
                    continue;
                } else {
                    while (true) {
                        System.out.print("Введите пароль: ");
                        String password = sc.nextLine();
                        mylog.logAdd(password, login);
                        if (password.length() < 8) {
                            System.out.println("Пароль должен содержать больше 7 символов");
                            continue;
                        } else {
                            // После создания логина и пароля, записываем в файл
                            String result = login + "-" + password + "\n";
                            Files.write(Paths.get(MyPathFile.USER.getPathWindow()), result.getBytes(), StandardOpenOption.APPEND);
//                            Files.write(Paths.get(MyPathFile.USER.getPathWindow()), result.getBytes(), StandardOpenOption.APPEND);
                            System.out.println(String.format("Вы успешно зарегистрировались %s!", login));
                            break;
                        }
                    }
                    break;
                }
            } else {
                System.out.println(String.format("Пользоваль с логином %s уже имеется в базе", login));
                break;
            }

        }
    }

    public static void showMenu() {
        System.out.println("Добро пожаловать в приложение ГСМ");
        System.out.println("1) Выберите 1 для регистрации пользователя;");
        System.out.println("2) Выберите 2 для авторизации;");
        System.out.println("3) Выберите 3 для выхода;");
    }
}
