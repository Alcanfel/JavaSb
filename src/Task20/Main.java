package Task20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


//        - добавить логирование действий (можно сделать позже, после реализации задачи 2).
//
//        * - сделать возможность добавлять и хранить информацию в разрезе каждого дня.



public class Main {
    public static void main(String[] args) throws IOException {
        MyLog mylog = new MyLog("logging.txt");

        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Добро пожаловать в приложение ГСМ");
            System.out.println("1) Выберите 1 для регистрации пользователя;");
            System.out.println("2) Выберите 2 для авторизации;");
            System.out.println("3) Выберите 3 для выхода;");
            Integer i = Integer.parseInt(sc.nextLine());
            String user = "Attenuator";
            mylog.logAdd(String.valueOf(i), user);
            if (i == 1){
                registration(sc);
                continue;
            } else if (i == 2){
                if (!autorisation(sc)){
                    System.out.println("Login or Password unknown");
                } else {

                    System.out.println("Команды:\n1) add C[code]_[gos]-[probeg]-[dop_par] - добавление информации об авто");
                    System.out.println("2) calc - вывод итоговой информации");
                    System.out.println("3) type [code] - вывод информации об отдельном типе авто");
                    System.out.println("4) exit - выход из программы");
                    String input;
                    String dataFile = "/home/attenuator/IdeaProjects/JavaSb/src/Task20/DataCar.txt";
                    //String dataFile = "C:\\Users\\aitov-af\\IdeaProjects\\TaskPart2\\src\\NewTask\\DataCar.txt";

                    do {
                        input = sc.nextLine();
                        mylog.logAdd(input, user);
                        switch (input.split(" ")[0]) {
                            case "calc": {
                                List<String> source = Files.readAllLines(Paths.get(dataFile));
                                //Создание массива экземпляров классов наследников Car
                                List<Car> listCar = Complete.creatArrayObjectReferenceCar(source);
                                ////Общую стоимость расходов на ГСМ, так и расходы на каждый класс авто
                                Complete.getTotalAndGroupCarGsm(listCar);
                                break;
                            }
                            case "add": {
                                if (Complete.checkAutoCode(input.split(" ")[1])) {
                                    Files.write(Paths.get(dataFile), "\n".getBytes(), StandardOpenOption.APPEND);
                                    Files.write(Paths.get(dataFile), input.split(" ")[1].getBytes(), StandardOpenOption.APPEND);
                                    System.out.println(String.format("+ запись %s добавлена в файл DataCar.txt", input.split(" ")[1]));
                                } else {
                                    System.out.println(String.format("- запись %s не добавлена, формат ошибочный", input.split(" ")[1]));
                                }
                                break;
                            }
                            case "type": {
                                List<String> source = Files.readAllLines(Paths.get(dataFile));
                                //Создание массива экземпляров классов наследников Car
                                List<Car> listCar = Complete.creatArrayObjectReferenceCar(source);
                                //Расходы ГСМ по типу авто
                                Complete.getTotalAndGroupCarGsm(listCar, input.split(" ")[1]);
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
            } else {
                System.out.println("Пока!");
                break;
            }
        }




    }

    // Авторизация
    public static boolean autorisation(Scanner sc) throws IOException {
        MyLog mylog = new MyLog("logging.txt");
        Map<String,String> mapUser = Complete.getDictFileUser();
        System.out.print("Введите логин: ");
        String login = sc.nextLine();
        mylog.logAdd(login, "Attenuator");
        if (!mapUser.containsKey(login)){
            System.out.println("Логин отсутствует в системе");
            return false;
        } else {
            System.out.print("Введите пароль: ");
            String password = sc.nextLine();
            mylog.logAdd(password, "Attenuator");
            if (mapUser.get(login).equals(password)){
                System.out.println(String.format("Добро пожаловать %s!",login));
                return true;

            } else {
                System.out.println("Пароль введен неверно");
                return false;
            }
        }
    }

    // Регистрация пользователя
    public static void registration(Scanner sc) throws IOException {
        MyLog mylog = new MyLog("logging.txt");
        Map<String, String> user = Complete.getDictFileUser();
        while (true){
            System.out.print("Введите логин: ");
            String login = sc.nextLine();
            mylog.logAdd(login, "Attenuator");
            if (!user.containsKey(login)){
                if (login.length()<8){
                    System.out.println("Логин должен быть больше 7 символов");
                    continue;
                } else {
                    while (true){
                        System.out.print("Введите пароль: ");
                        String password = sc.nextLine();
                        mylog.logAdd(password, "Attenuator");
                        if (password.length()<8){
                            System.out.println("Пароль должен содержать больше 7 символов");
                            continue;
                        } else {
                            String result = login + "-"+password+"\n";
                            //Files.write(Paths.get("/home/attenuator/IdeaProjects/JavaSb/src/Task20/User.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
                            Files.write(Paths.get("/home/attenuator/IdeaProjects/JavaSb/src/Task20/User.txt"), result.getBytes(), StandardOpenOption.APPEND);
                            //Files.write(Paths.get("/home/attenuator/IdeaProjects/JavaSb/src/Task20/User.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
                            //Files.write(Paths.get("C:\\Users\\aitov-af\\IdeaProjects\\TaskPart2\\src\\NewTask\\User.txt"), result.getBytes(), StandardOpenOption.APPEND);
                            System.out.println(String.format("Вы успешно зарегистрировались %s!", login));
                            break;
                        }
                    }
                    break;
                }
            } else {
                System.out.println(String.format("Пользоваль с логином %s уже имеется в базе", login));
            }

        }
    }


}
