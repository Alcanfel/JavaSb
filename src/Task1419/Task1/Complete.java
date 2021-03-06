package Task1419.Task1;


import javax.crypto.spec.PSource;
import javax.print.attribute.standard.PresentationDirection;
import java.util.*;

public class Complete {
    //Возвращает массив объектов наследников абстрактного класса Car
    public static List<Car> creatArrayObjectReferenceCar(String[] data) {

//        Для каждого типа свой тип топлива:
//        100 - 46.10
//        300 - 47.50
//        200, 400 - 48.90

//        расход топлива
//        100 - 12.5
//        200 - 12
//        300 - 11.5
//        400 - 20

        Map<String, Map> dictSource= unionSameCodeCarAndGosNomer(data);
        List<Car> listCar = new ArrayList<>();

        for ( String codeCar: dictSource.keySet()
        ) {
            for (Object gosNomer: dictSource.get(codeCar).keySet()
            ) {
            switch (Integer.parseInt(codeCar)) {
                case 100: {
                    Double i  = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(0);
                    Car car = new Car(codeCar, String.valueOf(gosNomer), i, 46.10, 12.5);
                    listCar.add(car);
                    break;
                }
                case 200: {
                    Double i  = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(0);
                    Double j = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(1);
                    Car car = new Car(codeCar, String.valueOf(gosNomer), i, j, 48.90, 12.0);
                    listCar.add(car);
                    break;
                }
                case 300: {
                    Double i  = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(0);
                    Double j = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(1);
                    Car car = new Car(codeCar, String.valueOf(gosNomer), i, j, 47.50, 11.5);
                    listCar.add(car);
                    break;
                }
                case 400: {
                    Double i  = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(0);
                    Double j = ((List<Double>)dictSource.get(codeCar).get(gosNomer)).get(1);
                    Car car = new Car(codeCar, String.valueOf(gosNomer), i, j, 48.90, 20.0);
                    listCar.add(car);
                    break;
                }
            }

            }
        }
        return listCar;
    }
    //"C200_1-120-1200",
    private static Map<String, Map> unionSameCodeCarAndGosNomer(String[] source) {


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
        for (int i = 0; i < source.length; i++) {
            Map<String, List> dictGosCode = new HashMap<>();
            String codecar = source[i].split("-")[0].split("_")[0].substring(1);
            String gosNomer = source[i].split("-")[0].split("_")[1];
            Double probeg = 0.0;
            Double dopparam = 0.0;
            if (source[i].split("-").length == 3) {
                List<Double> listProbefDopPar = new ArrayList<>();
                probeg = Double.parseDouble(source[i].split("-")[1]);
                dopparam = Double.parseDouble(source[i].split("-")[2]);
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
                probeg = Double.parseDouble(source[i].split("-")[1]);
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
    //Общую стоимость расходов на ГСМ, так и расходы на каждый класс авто
    public static void getTotalAndGroupCarGsm(List<Car> list){
        Map<String, Double> map = getDictAll(list);
        System.out.println("Общую стоимость расходов на ГСМ, так и расходы на каждый класс авто:");
        for (String key: map.keySet()
             ) {
            System.out.println(key + " - " + map.get(key));
        }
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
}
