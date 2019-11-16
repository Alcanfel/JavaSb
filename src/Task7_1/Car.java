package Task7_1;

public class Car {
    protected String gosNomer;
    protected double probeg;

    public Car(String gosNomer, double probeg) {
        this.gosNomer = gosNomer;
        this.probeg = probeg;
    }

    //Создал для имплементации
    public double getSummGsm() {
        return 0.0;
    }

    //Создал для имплементации
    public void printCar() {
    }

    //Возвращает общую стоимость расходов на ГСМ, так и расходы на каждый класс авто
    public static StringBuilder getTotalAndGroupCarGsm() {
        StringBuilder result = new StringBuilder();
        result.append("Total:");
        result.append(PassengerCar.sizeGsm + Bus.sizeGsm + HeavyMachine.sizeGsm + Truck.sizeGsm).append(", ");
        result.append(PassengerCar.getCodeSum()).append(", ");
        result.append(Bus.getCodeSum()).append(", ");
        result.append(HeavyMachine.getCodeSum()).append(", ");
        result.append(Truck.getCodeSum()).append(", ");
        return result;
    }

    //Возвращает тип авто имеющий наибольшую стоимость расходов
    public static String getCodeCarMaxRashod() {
        String[] array = {PassengerCar.getCodeSum(), Bus.getCodeSum(), HeavyMachine.getCodeSum(), Truck.getCodeSum()};
        double opor = Double.parseDouble(array[0].split(":")[1]);
        String result = array[1].split(":")[0];
        for (int i = 1; i < array.length; i++) {
            if (Double.parseDouble(array[i].split(":")[1]) > opor) {
                result = array[i].split(":")[0];
                opor = Double.parseDouble(array[i].split(":")[1]);
            }
        }
        return result;
    }

    //Возвращает тип авто имеющий наименьшую стоимость расходов
    public static String getCodeCarMinRashod() {
        String[] array = {PassengerCar.getCodeSum(), Bus.getCodeSum(), HeavyMachine.getCodeSum(), Truck.getCodeSum()};
        double opor = Double.parseDouble(array[0].split(":")[1]);
        String result = array[0].split(":")[0];
        for (int i = 1; i < array.length; i++) {
            if (opor > Double.parseDouble(array[i].split(":")[1])) {
                result = array[i].split(":")[0];
                opor = Double.parseDouble(array[i].split(":")[1]);
            }
        }
        return result;
    }

    //функция которая в разрезе каждого типа авто выводит информацию о каждом авто (тип, номер, пробег, доп. параметр), с сортировкой по пробегу или доп параметру.
    public static void printInfo(Object[] b) {
        String[] arrayInfo = new String[b.length];
        int i = 0;
        //Формируем общий массив по каждому автом ввида "тип:" + codeCar + "-номер:" + gosNomer + "-пробег:" + probeg;
        for (Object temp : b
        ) {
            Car s = (Car) temp;
            arrayInfo[i] = s.toString();
            i += 1;
        }

        //Создаем массивы по кажому ввиду авто
        String[] arrayPassengerCar = new String[PassengerCar.count];
        String[] arrayTruck = new String[Truck.count];
        String[] arrayBus = new String[Bus.count];
        String[] arrayHeavyMachine = new String[HeavyMachine.count];

        //Перебираем общий массив, добавляем по коду авто в соответствующий массив
        int p = 0, bu = 0, h = 0, t = 0;
        for (int j = 0; j < arrayInfo.length; j++) {
            switch (Integer.parseInt(arrayInfo[j].split("-")[0].split(":")[1])) {
                case 100: {
                    arrayPassengerCar[p] = arrayInfo[j];
                    p += 1;
                    break;
                }
                case 200: {
                    arrayTruck[t] = arrayInfo[j];
                    t += 1;
                    break;
                }
                case 300: {
                    arrayBus[bu] = arrayInfo[j];
                    bu += 1;
                    break;
                }
                case 400: {
                    arrayHeavyMachine[h] = arrayInfo[j];
                    h += 1;
                    break;
                }
            }
        }

        //По очереди перебираем осортированные знаечния по пробегу и выводим на экран
        for (String temp : sortArray(arrayPassengerCar)
        ) {
            System.out.println(temp);
        }

        for (String temp : sortArray(arrayTruck)
        ) {
            System.out.println(temp);
        }

        for (String temp : sortArray(arrayBus)
        ) {
            System.out.println(temp);
        }

        for (String temp : sortArray(arrayHeavyMachine)
        ) {
            System.out.println(temp);
        }
    }

    //Сортирует массив
    public static String[] sortArray(String[] b) {
        String[] result = new String[b.length];
        for (int i = b.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (Double.parseDouble(b[j].split("-")[2].split(":")[1]) > Double.parseDouble(b[j + 1].split("-")[2].split(":")[1])) {
                    String m = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = m;
                }
            }
        }


        return b;
    }

}

//Легковой автомобиль
class PassengerCar extends Car {
    public static int codeCar = 100;
    public static double typeToplivo = 46.10;
    public static double rashodToplivo = 12.5;
    public static double sizeGsm = 0.0;
    public static int count = 0; //увеличивается в конструкторе на 1 при создании экземпляра класса, необходим при создании массива

    //Конструктор, при создании экземпляра класса расчитывается расход за ГСМ и добавляется в статическую переменную класса
    public PassengerCar(String gosNomer, double probeg) {
        super(gosNomer, probeg);
        sizeGsm += (double) (((probeg / 100) * rashodToplivo) * typeToplivo);
        count+=1;

    }


    public double getSummGsm() {
        return (double) (((this.probeg / 100) * rashodToplivo) * typeToplivo);
    }


    public void printCar() {
        System.out.println("codeCar= " + codeCar + ", gosNomer= " + gosNomer + ", probeg= " + probeg);
    }

    public static String getCodeSum() {
        return codeCar + ":" + sizeGsm;
    }

    @Override
    public String toString() {
        return "тип:" + codeCar + "-номер:" + gosNomer + "-пробег:" + probeg;
    }

}

//Грузовой авто
class Truck extends Car {
    public static int codeCar = 200;
    public static double typeToplivo = 48.90;
    public static double rashodToplivo = 12.0;
    public static double sizeGsm = 0.0;
    private int dopParameter;
    public static int count = 0;

    public Truck(String gosNomer, double probeg, int dopParameter) {
        super(gosNomer, probeg);
        this.dopParameter = dopParameter;
        sizeGsm += (double) (((probeg / 100) * rashodToplivo) * typeToplivo);
        count += 1;
    }

    public double getSummGsm() {
        return (double) (((this.probeg / 100) * rashodToplivo) * typeToplivo);
    }

    public void printCar() {
        System.out.println("codeCar= " + codeCar + ", gosNomer= " + gosNomer + ", probeg= " + probeg + ", dopParameter=" + dopParameter);
    }

    public static String getCodeSum() {
        return codeCar + ":" + sizeGsm;
    }

    @Override
    public String toString() {
        return "тип:" + codeCar + "-номер:" + gosNomer + "-пробег:" + probeg + "-доп параметр:" + dopParameter;
    }
}

//Пассажирский автомобиль
class Bus extends Car {
    public static int codeCar = 300;
    public static double typeToplivo = 47.50;
    public static double rashodToplivo = 11.5;
    public static double sizeGsm = 0.0;
    private int dopParameter;
    public static int count = 0;

    public Bus(String gosNomer, double probeg, int dopParameter) {
        super(gosNomer, probeg);
        this.dopParameter = dopParameter;
        sizeGsm += (double) (((probeg / 100) * rashodToplivo) * typeToplivo);
        count += 1;
    }

    public double getSummGsm() {
        return (double) (((this.probeg / 100) * rashodToplivo) * typeToplivo);
    }

    public void printCar() {
        System.out.println("codeCar:" + codeCar + "-gosNomer:" + gosNomer + "-probeg:" + probeg + "-dopParameter:" + dopParameter);
    }

    public static String getCodeSum() {
        return codeCar + ":" + sizeGsm;
    }

    @Override
    public String toString() {
        return "тип:" + codeCar + "-номер:" + gosNomer + "-пробег:" + probeg + "-доп параметр:" + dopParameter;
    }

}

class HeavyMachine extends Car {
    public static int codeCar = 400;
    public static double typeToplivo = 48.90;
    public static double rashodToplivo = 20;
    public static double sizeGsm = 0.0;
    private int dopParameter;
    public static int count = 0;

    public HeavyMachine(String gosNomer, double probeg, int dopParameter) {
        super(gosNomer, probeg);
        this.dopParameter = dopParameter;
        sizeGsm += (double) (((probeg / 100) * rashodToplivo) * typeToplivo);
        count += 1;
    }

    public double getSummGsm() {
        return (double) (((this.probeg / 100) * rashodToplivo) * typeToplivo);
    }

    public void printCar() {
        System.out.println("codeCar= " + codeCar + ", gosNomer= " + gosNomer + ", probeg= " + probeg + ", dopParameter=" + dopParameter);
    }

    public static String getCodeSum() {
        return codeCar + ":" + sizeGsm;
    }

    @Override
    public String toString() {
        return "тип:" + codeCar + "-номер:" + gosNomer + "-пробег:" + probeg + "-доп параметр:" + dopParameter;
    }

}
