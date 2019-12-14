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

        while (true){ // в бесконечном цикле будем ожидать действия от пользователя, выйти из цила цифра 3
            Scanner sc = new Scanner(System.in);
            System.out.println("Добро пожаловать в приложение ГСМ");
            System.out.println("1) Выберите 1 для регистрации пользователя;");
            System.out.println("2) Выберите 2 для авторизации;");
            System.out.println("3) Выберите 3 для выхода;");
            String i = sc.nextLine();
            String user = "noname"; // Пока что не знаем имя пользователя
            mylog.logAdd(String.valueOf(i), user);
            if (i.equals("1")){
                registration(sc);  //  Вызывается метод регистрации
                continue; // далее повторяем, переходим к след итерации
            } else if (i.equals("2")){
                String loginUser = autorisation(sc);
                if (loginUser.equals("Пусто")){ // Авторизация
                    System.out.println("Login or Password unknown");
                    continue;
                } else {
                    Date dateNow = new Date();
                    SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println(String.format("Добрый день, %s\nОперационный день: %s", loginUser, formatForDateNow.format(dateNow)));
                    System.out.println("Вам доступны операции:\n1) add C[code]_[gos]-[probeg]-[dop_par] - добавление информации об авто в текущем опер дне.");
                    System.out.println("2) calc dd/mm/yyyy- вывод итоговой информации по дате, если дату не указывать, выводит общую по всем датам");
                    System.out.println("3) type [code] dd/mm/yyyy- вывод информации об отдельном типе авто, если дату не указывать, выводит общую по всем датам");
                    System.out.println("4) exit - выход из программы");
                    String input;
                    // Путь к файлу хранится в энуме
                    //String dataFile = MyPathFile.DATACAR.getPathUbuntu();
                    String dataFile = MyPathFile.DATACAR.getPathUbuntu();

                    do {
                        input = sc.nextLine();
                        mylog.logAdd(input, loginUser);
                        switch (input.split(" ")[0]) {
                            case "calc": {
                                if (input.split(" ").length==2){
                                    List<String> source = Files.readAllLines(Paths.get(dataFile));
                                    Map<String, List<Car>> mapCarGroupDate = Complete.creatMapObjectCarGroupDate(source);
                                    Complete.getTotalAndGroupCarGsm(mapCarGroupDate, input.split(" ")[1]);

                                } else {
                                    List<String> source = Files.readAllLines(Paths.get(dataFile));
                                    List<String> sourceMain = new ArrayList<>();
                                    for (String str: source
                                         ) {
                                        sourceMain.add(str.split(" - ")[1]);
                                    }
//                                    Создание массива экземпляров классов наследников Car
                                    List<Car> listCar = Complete.creatListObjectCarAllTime(sourceMain);
                                    //Общую стоимость расходов на ГСМ, так и расходы на каждый класс авто
                                    Complete.getTotalAndGroupCarGsm(listCar);
                                }

                                break;
                            }
                            case "add": {
                                if (Complete.checkAutoCode(input.split(" ")[1])) {
                                    Files.write(Paths.get(dataFile), "\n".getBytes(), StandardOpenOption.APPEND);
                                    Files.write(Paths.get(dataFile), formatForDateNow.format(dateNow).getBytes(), StandardOpenOption.APPEND); // Добавляем дату
                                    Files.write(Paths.get(dataFile), " - ".getBytes(), StandardOpenOption.APPEND); // Разделяем тире
                                    Files.write(Paths.get(dataFile), input.split(" ")[1].getBytes(), StandardOpenOption.APPEND);
                                    System.out.println(String.format("+ запись %s добавлена в файл DataCar.txt", input.split(" ")[1]));
                                } else {
                                    System.out.println(String.format("- запись %s не добавлена, формат ошибочный", input.split(" ")[1]));
                                }
                                break;
                            }
                            case "type": {
                                List<String> source = Files.readAllLines(Paths.get(dataFile));
                                if (input.split(" ").length==2){
//                                Создание массива экземпляров классов наследников Car
                                List<String> sourceMain = new ArrayList<>();
                                for (String str: source
                                ) {
                                    sourceMain.add(str.split(" - ")[1]);
                                }
                                List<Car> listCar = Complete.creatListObjectCarAllTime(sourceMain);
                                //Расходы ГСМ по типу авто
                                Complete.getTotalAndGroupCarGsm(listCar, input.split(" ")[1]);
                                break;
                                } else if (input.split(" ").length==3) {
                                    Map<String, List<Car>> mapCarGroupDate = Complete.creatMapObjectCarGroupDate(source);
                                    Complete.getTotalAndGroupCarGsm(mapCarGroupDate, input.split(" ")[1], input.split(" ")[2]);
                                    break;
                                } else {
                                    System.out.println("Вы не указали код автомобиля");
                                    break;
                                }
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
                continue;
            } else if (i.equals("3")){
                System.out.println("Пока!");
                break;
            } else {
                System.out.println("Нужно выбрать 1, 2 или 3");
                continue;
            }
        }




    }

    // Авторизация
    public static String autorisation(Scanner sc) throws IOException {
        MyLog mylog = new MyLog("logging.txt");
        Map<String,String> mapUser = Complete.getDictFileUser(); // словарь c пользваотелями
        System.out.print("Введите логин: ");
        String login = sc.nextLine();
        mylog.logAdd(login, login);
        if (!mapUser.containsKey(login)){
            System.out.println("Логин отсутствует в системе");
            return "Пусто";
        } else {
            System.out.print("Введите пароль: ");
            String password = sc.nextLine();
            mylog.logAdd(password, login);
            if (mapUser.get(login).equals(password)){
                return login;

            } else {
                System.out.println("Пароль введен неверно");
                return "Пусто";
            }
        }
    }

    // Регистрация пользователя
    public static void registration(Scanner sc) throws IOException {
        MyLog mylog = new MyLog("logging.txt");
        Map<String, String> user = Complete.getDictFileUser(); // словарь для пользователя (Логин-пароль)
        while (true){ // Бескоечный цикл, где выход это обязательная регистрация или если логин уже имеется в файле
            System.out.print("Введите логин: ");
            String login = sc.nextLine();
            mylog.logAdd(login, "noname");
            if (!user.containsKey(login)){ // Проверяем на наличие логина в файле, если есть идем дальше, нет выходим в главное регистрации и авторизации
                if (login.length()<8){  //  Проверяем длину
                    System.out.println("Логин должен быть больше 7 символов");
                    continue;
                } else {
                    while (true){
                        System.out.print("Введите пароль: ");
                        String password = sc.nextLine();
                        mylog.logAdd(password, login);
                        if (password.length()<8){
                            System.out.println("Пароль должен содержать больше 7 символов");
                            continue;
                        } else {
                            // После создания логина и пароля, записываем в файл
                            String result = login + "-"+password+"\n";
                            Files.write(Paths.get(MyPathFile.USER.getPathUbuntu()), result.getBytes(), StandardOpenOption.APPEND);
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


}
