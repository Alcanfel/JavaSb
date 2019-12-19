package Task20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MainCar {
    public static void calc(String input) throws IOException {
        String dataFile = MyPathFile.DATACAR.getPathWindow();
        // Если указана дата то выводим по дате
        if (input.split(" ").length==2){
            List<String> source = Files.readAllLines(Paths.get(dataFile)); //  Считываем файл
            Map<String, List<Car>> mapCarGroupDate = Complete.creatMapObjectCarGroupDate(source); //  Формируем мапу с объектами Car сгруппированых по дате
            Complete.getTotalAndGroupCarGsm(mapCarGroupDate, input.split(" ")[1]); //  Расчитываем стоимость и выводим по дате кторую передали

        } else {
            // Если не указана дата формируем за все дни
            List<String> source = Files.readAllLines(Paths.get(dataFile)); //  Считываем файл
            List<String> sourceMain = new ArrayList<>(); //  Избавляемся от даты
            for (String str: source
            ) {
                sourceMain.add(str.split(" - ")[1]);
            }
//                                    Создание списка экземпляров Car
            List<Car> listCar = Complete.creatListObjectCarAllTime(sourceMain);
            //Общую стоимость расходов на ГСМ, так и расходы на каждый класс авто
            Complete.getTotalAndGroupCarGsm(listCar);
        }
    }

    public static void add(String input) throws IOException {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy");
        String dataFile = MyPathFile.DATACAR.getPathWindow();
        if (Complete.checkAutoCode(input.split(" ")[1])) {
            Files.write(Paths.get(dataFile), "\n".getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(dataFile), formatForDateNow.format(dateNow).getBytes(), StandardOpenOption.APPEND); // Добавляем дату
            Files.write(Paths.get(dataFile), " - ".getBytes(), StandardOpenOption.APPEND); // Разделяем тире
            Files.write(Paths.get(dataFile), input.split(" ")[1].getBytes(), StandardOpenOption.APPEND);
            System.out.println(String.format("+ запись %s добавлена в файл DataCar.txt", input.split(" ")[1]));
        } else {
            System.out.println(String.format("- запись %s не добавлена, формат ошибочный", input.split(" ")[1]));
        }
    }

    public static void type(String input) throws IOException {
        String dataFile = MyPathFile.DATACAR.getPathWindow();
        List<String> source = Files.readAllLines(Paths.get(dataFile));
        //  Если передали только код автомобиля, рассчитываем за все дни
        if (input.split(" ").length==2){
//                              //  Избавляемся от даты
            List<String> sourceMain = new ArrayList<>();
            for (String str: source
            ) {
                sourceMain.add(str.split(" - ")[1]);
            }
            // Формируем список экземпляров Car
            List<Car> listCar = Complete.creatListObjectCarAllTime(sourceMain);
            //  рассчитываем ГСМ по всем автомобилям и выводим по нужному коду
            Complete.getTotalAndGroupCarGsm(listCar, input.split(" ")[1]);
        } else if (input.split(" ").length==3) {
            // Если передали дату, формируем мапу экземплярво автомобилей группированных по дате
            Map<String, List<Car>> mapCarGroupDate = Complete.creatMapObjectCarGroupDate(source);
            //Выводим стоимость ГСМ по определенному типу и за определенную дату
            Complete.getTotalAndGroupCarGsm(mapCarGroupDate, input.split(" ")[1], input.split(" ")[2]);
        } else {
            System.out.println("Вы не указали код автомобиля");
        }
    }

    public static void showMenu(String loginUser){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(String.format("Добрый день, %s\nОперационный день: %s", loginUser, formatForDateNow.format(dateNow)));
        System.out.println("Вам доступны операции:\n1) add C[code]_[gos]-[probeg]-[dop_par] - добавление информации об авто в текущем опер дне.");
        System.out.println("2) calc dd/mm/yyyy- вывод итоговой информации по дате, если дату не указывать, выводит общую по всем датам");
        System.out.println("3) type [code] dd/mm/yyyy- вывод информации об отдельном типе авто, если дату не указывать, выводит общую по всем датам");
        System.out.println("4) exit - выход из программы");
    }
}
