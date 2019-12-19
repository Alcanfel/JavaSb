package Task20;


import javax.crypto.spec.PSource;
import javax.print.attribute.standard.PresentationDirection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Complete {
    //Возвращает словарь где ключ это дата, а значение список экземпляров класса Car
    public static Map<String, List<Car>> creatMapObjectCarGroupDate(List<String> data) throws IOException {

//        Map<String, Double> mapPriceFuel = getDictFile(MyPathFile.PRICEFUEL.getPathWindow());
        Map<String, Double> mapPriceFuel = getDictFile(MyPathFile.PRICEFUEL.getPathWindow());
//        Map<String, Double> mapRateFuel = getDictFile(MyPathFile.RATEFUEL.getPathWindow());
        Map<String, Double> mapRateFuel = getDictFile(MyPathFile.RATEFUEL.getPathWindow());

        Map<String, Map> dictSource= unionSameCodeCarAndGosNomerGroupDate(data);
        Map<String, List<Car>> dictCarGroupDate = new HashMap<>();

        for (String groupDate: dictSource.keySet()
             ) {
            List<Car> listCar = new ArrayList<>();
            for ( Object codeCar: dictSource.get(groupDate).keySet()
            ) {
                Map<String, List> mapLevel3 = (Map<String, List>) dictSource.get(groupDate).get(String.valueOf(codeCar));
                for (Object gosNomer: mapLevel3.keySet()
                ) {
                    if (Integer.parseInt((String) codeCar) == 100){
                        Double i  = ((List<Double>)mapLevel3.get(gosNomer)).get(0);
                        Car car = new Car((String) codeCar, String.valueOf(gosNomer), i, mapPriceFuel.get(codeCar), mapRateFuel.get(codeCar));
                        listCar.add(car);
                    } else {
                        Double i  = ((List<Double>)mapLevel3.get(gosNomer)).get(0);
                        Double j = ((List<Double>)mapLevel3.get(gosNomer)).get(1);
                        Car car = new Car((String) codeCar, String.valueOf(gosNomer), i, j, mapPriceFuel.get(codeCar), mapRateFuel.get(codeCar));
                        listCar.add(car);
                    }
                }
            }
            dictCarGroupDate.put(groupDate, listCar);
        }


        return dictCarGroupDate;
    }

    //Возвращает список объектов Car за все время
    public static List<Car> creatListObjectCarAllTime(List<String> data) throws IOException {

        Map<String, Double> mapPriceFuel = getDictFile(MyPathFile.PRICEFUEL.getPathWindow());
        Map<String, Double> mapRateFuel = getDictFile(MyPathFile.RATEFUEL.getPathWindow());

        Map<String, Map> dictSource= unionSameCodeCarAndGosNomer(data);
        List<Car> listCar = new ArrayList<>();

        for ( String codeCar: dictSource.keySet()
        ) {
            for (Object gosNomer: dictSource.get(codeCar).keySet()
            ) {
                if (Integer.parseInt((String) codeCar) == 100){
                    Double i  = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(0);
                    Car car = new Car(codeCar, String.valueOf(gosNomer), i, mapPriceFuel.get(codeCar), mapRateFuel.get(codeCar));
                    listCar.add(car);
                } else {
                    Double i  = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(0);
                    Double j = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(1);
                    Car car = new Car(codeCar, String.valueOf(gosNomer), i, j, mapPriceFuel.get(codeCar), mapRateFuel.get(codeCar));
                    listCar.add(car);
                }
            }
        }
        return listCar;
    }

    // Формирует словарь из данных в файле
    private static Map<String, Double> getDictFile(String path) throws IOException {
        Map<String, Double> mapResult = new HashMap<>();
        List<String> source = Files.readAllLines(Paths.get(path));
        for (String s: source
             ) {
            mapResult.put(s.split("-")[0], Double.parseDouble(s.split("-")[1]));
        }
        return mapResult;
    }

    //"C200_1-120-1200",
    //Преобразуем массив в словарь, объединяет пробеги одинаковых автомобилей и группирует по дате
    private static Map<String, Map> unionSameCodeCarAndGosNomerGroupDate(List<String> sourceData) {


        /*
        Преобразуем массив в словарь вида:
        '13/12/2019':{
                        400:{
                            1:[80.0, 20.0],
                            2:[10.0, 20.0],
                            3:[100.0, 28.0],
                            },
                        100:{
                            1: [600.0],
                            2: [50.0],
                            3: [10.0],
                            },
                        200:
                            {
                            1: [220.0, 1300.0],
                            2: [40.0, 1000.0],
                            3: [170.0, 1100.0],
                            },
                        300:{
                            1: [152.0, 62.0],
                            2: [200.0, 45.0],
                            3: [150.0, 29.0],
                            }
                     }
 */
        Map<String, Map> dictGroupDate = new HashMap<>();

        //C100_1-100-1233
        for (String sourceall: sourceData) {
            Map<String, Map> dictAuto = new HashMap<>();
            Map<String, List> dictGosCode = new HashMap<>();
            String keyDate = sourceall.split(" - ")[0];
            String source = sourceall.split(" - ")[1];
            String codecar = source.split("-")[0].split("_")[0].substring(1);
            String gosNomer = source.split("-")[0].split("_")[1];
            Double probeg = 0.0;
            Double dopparam = 0.0;

            if (source.split("-").length == 3) {
                List<Double> listProbefDopPar = new ArrayList<>();
                probeg = Double.parseDouble(source.split("-")[1]);
                dopparam = Double.parseDouble(source.split("-")[2]);
                listProbefDopPar.add(probeg);
                listProbefDopPar.add(dopparam);

                if (!dictGroupDate.containsKey(keyDate)) // Проверяем на наличие в мапе ключа даты
                    // нету, значит можно с нуля все собрать
                {   dictGosCode.put(gosNomer, listProbefDopPar);
                    dictAuto.put(codecar,dictGosCode);
                    dictGroupDate.put(keyDate, dictAuto);
                } else
                    // Дата имеется, значит проверяем по коду автомобиля
                    {
                    if (!dictGroupDate.get(keyDate).containsKey(codecar)){
                        // кода автомобиля нет, значит собираем с нуля и добавляем как значение ключа даты
                        dictGosCode.put(gosNomer, listProbefDopPar);
                        dictGroupDate.get(keyDate).put(codecar,dictGosCode);
                    } else
                        // код автомобиля имеется,
                        { // проверяем по гос номеру
                         Map<String, List> dictGosCodeOld = (Map<String, List>) dictGroupDate.get(keyDate).get(codecar);
                        if (!dictGosCodeOld.containsKey(gosNomer)){
                            // го номер нет, добавляем
                            dictGosCodeOld.put(gosNomer, listProbefDopPar);
                            dictGroupDate.get(keyDate).put(codecar,dictGosCodeOld);

                        }
                        else {
                            List<Double> listProbefDopParOld = new ArrayList<>();
                            listProbefDopParOld.add(((List<Double>)dictGosCodeOld.get(gosNomer)).get(0)+probeg);
                            listProbefDopParOld.add(((List<Double>)dictGosCodeOld.get(gosNomer)).get(1)+dopparam);
                            dictGosCodeOld.put(gosNomer, listProbefDopParOld);
                            dictGroupDate.get(keyDate).put(codecar,dictGosCodeOld);
                        }
                    }
                }


            } else {
                List<Double> listProbefDopPar = new ArrayList<>();
                probeg = Double.parseDouble(source.split("-")[1]);
                listProbefDopPar.add(probeg);

                if (!dictGroupDate.containsKey(keyDate)) // Проверяем на наличие в мапе ключа даты
                // нету, значит можно с нуля все собрать
                {   dictGosCode.put(gosNomer, listProbefDopPar);
                    dictAuto.put(codecar,dictGosCode);
                    dictGroupDate.put(keyDate, dictAuto);
                } else
                // Дата имеется, значит проверяем по коду автомобиля
                {
                    if (!dictGroupDate.get(keyDate).containsKey(codecar)){
                        // кода автомобиля нет, значит собираем с нуля и добавляем как значение ключа даты
                        dictGosCode.put(gosNomer, listProbefDopPar);
                        dictGroupDate.get(keyDate).put(codecar,dictGosCode);
                    } else
                    // код автомобиля имеется,
                    { // проверяем по гос номеру
                        Map<String, List> dictGosCodeOld = (Map<String, List>) dictGroupDate.get(keyDate).get(codecar);
                        if (!dictGosCodeOld.containsKey(gosNomer)){
                            // го номер нет, добавляем
                            dictGosCodeOld.put(gosNomer, listProbefDopPar);
                            dictGroupDate.get(keyDate).put(codecar,dictGosCodeOld);

                        }
                        else {
                            List<Double> listProbefDopParOld = new ArrayList<>();
                            listProbefDopParOld.add(((List<Double>)dictGosCodeOld.get(gosNomer)).get(0)+probeg);
                            dictGosCodeOld.put(gosNomer, listProbefDopParOld);
                            dictGroupDate.get(keyDate).put(codecar,dictGosCodeOld);
                        }
                    }
                }
            }


        }
        return dictGroupDate;
    }


    //Преобразуем массив в словарь, объединяет пробеги одинаковых автомобилей за все время
    private static Map<String, Map> unionSameCodeCarAndGosNomer(List<String> sourceData) {


        /*
        Преобразуем массив в словарь вида:
        400:{
            1:[80.0, 20.0],
            2:[10.0, 20.0],
            3:[100.0, 28.0],
            },
        100:{
            1: [600.0],
            2: [50.0],
            3: [10.0],
            },
        200:
            {
            1: [220.0, 1300.0],
            2: [40.0, 1000.0],
            3: [170.0, 1100.0],
            },
        300:{
            1: [152.0, 62.0],
            2: [200.0, 45.0],
            3: [150.0, 29.0],
            }
 */

        Map<String, Map> dictAuto = new HashMap<>();
        //C100_1-100-1233
        for (String source: sourceData) {
            Map<String, List> dictGosCode = new HashMap<>();
            String codecar = source.split("-")[0].split("_")[0].substring(1);
            String gosNomer = source.split("-")[0].split("_")[1];
            Double probeg = 0.0;
            Double dopparam = 0.0;
            if (source.split("-").length == 3) {
                List<Double> listProbefDopPar = new ArrayList<>();
                probeg = Double.parseDouble(source.split("-")[1]);
                dopparam = Double.parseDouble(source.split("-")[2]);
                listProbefDopPar.add(probeg);
                listProbefDopPar.add(dopparam);
                if (!dictAuto.containsKey(codecar)){
                    dictGosCode.put(gosNomer, listProbefDopPar);
                    dictAuto.put(codecar,dictGosCode);
                } else {
                    if (!dictAuto.get(codecar).containsKey(gosNomer)){
                        dictAuto.get(codecar).put(gosNomer, listProbefDopPar);
                    }
                    else {
                        List<Double> listProbefDopParOld = new ArrayList<>();
                        listProbefDopParOld.add(((List<Double>)dictAuto.get(codecar).get(gosNomer)).get(0)+probeg);
                        listProbefDopParOld.add(((List<Double>)dictAuto.get(codecar).get(gosNomer)).get(1)+probeg);
                        dictAuto.get(codecar).put(gosNomer, listProbefDopParOld);
                    }
                }
            } else {
                List<Double> listProbefDopPar = new ArrayList<>();
                probeg = Double.parseDouble(source.split("-")[1]);
                listProbefDopPar.add(probeg);
                if (!dictAuto.containsKey(codecar)){
                    dictGosCode.put(gosNomer, listProbefDopPar);
                    dictAuto.put(codecar,dictGosCode);
                } else {
                    if (!dictAuto.get(codecar).containsKey(gosNomer)){
                        dictAuto.get(codecar).put(gosNomer, listProbefDopPar);
                    }
                    else {
                        List<Double> listProbefDopParOld = new ArrayList<>();
                        listProbefDopParOld.add(((List<Double>)dictAuto.get(codecar).get(gosNomer)).get(0)+probeg);
                        dictAuto.get(codecar).put(gosNomer, listProbefDopParOld);
                    }
                }
            }


        }
        return dictAuto;
    }

    //Общую стоимость расходов на ГСМ, так и расходы на каждый класс авто за дату
    public static void getTotalAndGroupCarGsm(Map<String, List<Car>> list, String date){
        if (list.get(date) != null){
            Map<String, Double> map = getDictAll(list.get(date));
            System.out.println(String.format("Вывод итоговой информации за операционный день %s:", date));
            for (String key: map.keySet()
            ) {
                System.out.println(key + " - " + map.get(key));
            }
        } else System.out.println(String.format("Данные за дату %s отсутствуют",date));

    }

    // Расходы на определенный класс авто за определенную дату
    public static void getTotalAndGroupCarGsm(Map<String, List<Car>> list, String typeCode, String date){
        if (list.get(date) != null){
            Map<String, Double> map = getDictAll(list.get(date));
            System.out.println(String.format("Вывод итоговой информации за операционный день %s:", date));
            System.out.println(String.format("Вывод информации об авто с кодом %s:", typeCode));
            System.out.println(typeCode + " - " + map.get(typeCode));
        } else System.out.println(String.format("Данные за дату %s отсутствуют",date));

    }

    //Общую стоимость расходов на ГСМ, так и расходы на каждый класс авто за все время
    public static void getTotalAndGroupCarGsm(List<Car> list){

        Map<String, Double> map = getDictAll(list);
        System.out.println(String.format("Вывод итоговой информации за всё время:"));
        for (String key: map.keySet()
        ) {
            System.out.println(key + " - " + map.get(key));
        }
    }

    public static void getTotalAndGroupCarGsm(List<Car> list, String codeCar){
        Map<String, Double> map = getDictAll(list);
        System.out.println(String.format("Вывод информации об авто с кодом %s:", codeCar));
        System.out.println(codeCar + " - " + map.get(codeCar));
    }

    //Возвращает тип авто имеющий наибольшую стоимость расходов
    public static String getCodeCarMaxRashod(List<Car> list){
        Map<String, Double> map = new HashMap<>(getDictAuto(list));
        List list1 = new ArrayList(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Double>>() {

            @Override
            public int compare(Map.Entry<String, Double> a, Map.Entry<String, Double> b) {
                return (int) (a.getValue() - b.getValue());
            }
        });
        return "тип авто имеющий наибольшую стоимость расходов: " + String.valueOf(list1.get(list1.size()-1)).split("=")[0];

    }

    //Возвращает тип авто имеющий наименьшую стоимость расходов
    public static String getCodeCarMinRashod(List<Car> list){
        Map<String, Double> map = new HashMap<>(getDictAuto(list));
        List list1 = new ArrayList(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Double>>() {

            @Override
            public int compare(Map.Entry<String, Double> a, Map.Entry<String, Double> b) {
                return (int) (a.getValue() - b.getValue());
            }
        });
        return "тип авто имеющий наименьшую стоимость расходов: " + String.valueOf(list1.get(0)).split("=")[0];

    }

    //реализовать функции которые в разрезе каждого типа авто выводят информацию о каждом авто (тип, номер, пробег, доп. параметр), с сортировкой по пробегу и доп параметру.
    public static void printInfo(List source){
        Collections.sort(source);
        for (Object car: source
             ) {
            System.out.println(((Car) car).toString());
        }
    }

    public static Map<String, Double> getDictAll(List<Car> list){
        Map<String, Double> map = new HashMap<>();
        double all = 0;
        for (Car car: list
        ) {
            if (!map.containsKey(car.getCodeCar())){
                map.put(car.getCodeCar(), car.getGsm());
            }else {
                double i = map.get(car.getCodeCar());
                map.put(car.getCodeCar(), i + car.getGsm());
            }
            all += car.getGsm();
            map.put("AllPrice", all);

        }
        return map;
    }

    public static Map<String, Double> getDictAuto(List<Car> list){
        Map<String, Double> map = new HashMap<>();
        for (Car car: list
        ) {
            if (!map.containsKey(car.getCodeCar())){
                map.put(car.getCodeCar(), car.getGsm());
            }else {
                double i = map.get(car.getCodeCar());
                map.put(car.getCodeCar(), i + car.getGsm());
            }
        }
        return map;
    }

    // проверка строки на корректность ввода, у типа 100 не должно быть доп параметра, по все остальным должен передавваться доп параметр
    public static boolean checkAutoCode(String s) {
        if (s.split("-")[0].split("_")[0].substring(1).equals("100")){
            if (Pattern.matches("C\\d*_\\d*-\\d*",s) && s.split("-").length == 2){
                return true;
            } else return false;
        } else{
            if (Pattern.matches("C\\d*_\\d*-\\d*-*\\d*",s) && s.split("-").length == 3){
                return true;
            } else return false;
        }
        }


    // Получить словарь пользователей, словарь формируется по файлу User.txt
    public static Map<String, String> getDictFileUser() throws IOException {
        Map<String, String> mapResult = new HashMap<>();
        List<String> source = Files.readAllLines(Paths.get(MyPathFile.USER.getPathWindow()));
        for (String s: source
        ) {
            mapResult.put(s.split("-")[0], s.split("-")[1]);
        }
        return mapResult;
    }
}
