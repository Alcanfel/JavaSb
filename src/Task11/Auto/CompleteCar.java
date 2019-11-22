package Task11.Auto;

public class CompleteCar {
    //Возвращает массив объектов наследников абстрактного класса Car
    public static Object[] creatArrayObjectReferenceCar(String[] data) {

//        Для каждого типа свой тип топлива:
//        100 - 46.10
//        300 - 47.50
//        200, 400 - 48.90

//        расход топлива
//        100 - 12.5
//        200 - 12
//        300 - 11.5
//        400 - 20

        String[] source = unionSameCodeCarAndGosNomer(data);
        Object[] array_object = new Object[source.length]; //создаем массив объектов с длиной переданного массива строк
        for (int i = 0; i < source.length; i++) {

            //Разбираем строки по значениям и создаем объекты классов наследников Car
            switch (Integer.parseInt(source[i].split("-")[0].split("_")[0])) {
                case 100: {
                    array_object[i] = new PassengerCar(Integer.parseInt(source[i].split("-")[0].split("_")[0]),
                            source[i].split("-")[0].split("_")[1],
                            Double.parseDouble(source[i].split("-")[1]), 46.10, 12.5);
                    break;
                }
                case 200: {
                    array_object[i] = new Truck(Integer.parseInt(source[i].split("-")[0].split("_")[0]),
                            source[i].split("-")[0].split("_")[1],
                            Double.parseDouble(source[i].split("-")[1]),
                            Integer.parseInt(source[i].split("-")[2]), 48.90, 12);
                    break;
                }
                case 300: {
                    array_object[i] = new Bus(Integer.parseInt(source[i].split("-")[0].split("_")[0]),
                            source[i].split("-")[0].split("_")[1],
                            Double.parseDouble(source[i].split("-")[1]),
                            Integer.parseInt(source[i].split("-")[2]), 47.50, 11.5);
                    break;
                }
                case 400: {
                    array_object[i] = new HeavyMachine(Integer.parseInt(source[i].split("-")[0].split("_")[0]),
                            source[i].split("-")[0].split("_")[1],
                            Double.parseDouble(source[i].split("-")[1]),
                            Integer.parseInt(source[i].split("-")[2]), 48.90, 20);
                    break;
                }
            }
        }
        return array_object;
    }

    //просуммировать с данными авто с тем же гос номером
    private static String[] unionSameCodeCarAndGosNomer(String[] source) {
        StringBuilder result = new StringBuilder();
        //C100_1-100-1233
        for (int i = 0; i < source.length; i++) {
            if (result.indexOf(source[i].split("-")[0].substring(1)) == -1) {
                int probeg = 0;
                int dopparam = 0;

                if (source[i].split("-").length == 3) {
                    probeg = Integer.parseInt(source[i].split("-")[1]);
                    dopparam = Integer.parseInt(source[i].split("-")[2]);
                } else {
                    probeg = Integer.parseInt(source[i].split("-")[1]);
                }

                for (int j = i + 1; j < source.length; j++) {
                    if (source[i].split("-")[0].substring(1).equals(source[j].split("-")[0].substring(1))) {
                        if (source[i].split("-").length == 3) {
                            probeg += Integer.parseInt(source[j].split("-")[1]);
                            dopparam += Integer.parseInt(source[j].split("-")[2]);
                        } else {
                            probeg += Integer.parseInt(source[j].split("-")[1]);
                        }

                    }
                }

                if (source[i].split("-").length == 3) {
                    result.append(source[i].split("-")[0].substring(1)).append("-").append(probeg).append("-").append(dopparam).append("#");
                } else {
                    result.append(source[i].split("-")[0].substring(1)).append("-").append(probeg).append("#");
                }
            }
        }

        return String.valueOf(result).split("#");
    }

    // общая стоимость расходов на ГСМ, так и расходы на каждый класс авто
    public static StringBuilder getTotalAndGroupCarGsm() {
        StringBuilder result = new StringBuilder();
        result.append(getTotalSum());
        result.append(PassengerCar.getSizeGsm());
        result.append(Bus.getSizeGsm());
        result.append(HeavyMachine.getSizeGsm());
        result.append(Truck.getSizeGsm());
        return result;
    }

        //Возвращает тип авто имеющий наибольшую стоимость расходов
    public static String getCodeCarMaxRashod() {
        String[] array = {PassengerCar.getSizeGsm(), Bus.getSizeGsm(), HeavyMachine.getSizeGsm(), Truck.getSizeGsm()};
        double opor = Double.parseDouble(array[0].split(": ")[1]);
        String result = array[1].split(": ")[0];
        for (int i = 1; i < array.length; i++) {
            if (Double.parseDouble(array[i].split(": ")[1]) > opor) {
                result = array[i].split(": ")[0];
                opor = Double.parseDouble(array[i].split(": ")[1]);
            }
        }
        return result;
    }
        //Возвращает тип авто имеющий наименьшую стоимость расходов
    public static String getCodeCarMinRashod() {
        String[] array = {PassengerCar.getSizeGsm(), Bus.getSizeGsm(), HeavyMachine.getSizeGsm(), Truck.getSizeGsm()};
        double opor = Double.parseDouble(array[0].split(": ")[1]);
        String result = array[0].split(": ")[0];
        for (int i = 1; i < array.length; i++) {
            if (opor > Double.parseDouble(array[i].split(": ")[1])) {
                result = array[i].split(":")[0];
                opor = Double.parseDouble(array[i].split(": ")[1]);
            }
        }
        return result;
    }

    public static void printInfo(Object[] source){
        String[] result = new String[source.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = source[i].toString();
        }

        for (int i = result.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (
                        Integer.parseInt(result[j].split(", ")[0].split("=")[1]) > Integer.parseInt(result[j+1].split(", ")[0].split("=")[1])
                ) {
                    String elem = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = elem;
                }
            }
        }

        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }

    }
    private static String getTotalSum(){
        return "Total: "+ String.valueOf(PassengerCar.sizeGsm + Bus.sizeGsm + HeavyMachine.sizeGsm + Truck.sizeGsm) + ";\n";
    }


}
