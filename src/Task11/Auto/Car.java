package Task11.Auto;

public abstract class Car {
    private int codeCar;
    private double typeToplivo;
    private double rashodToplivo;
    private String gosNomer;
    private double probeg;

    //Геттеры  и сеттеры

    public int getCodeCar() {
        return codeCar;
    }

    public void setCodeCar(int codeCar) {
        this.codeCar = codeCar;
    }

    public double getTypeToplivo() {
        return typeToplivo;
    }

    public void setTypeToplivo(double typeToplivo) {
        this.typeToplivo = typeToplivo;
    }

    public double getRashodToplivo() {
        return rashodToplivo;
    }

    public void setRashodToplivo(double rashodToplivo) {
        this.rashodToplivo = rashodToplivo;
    }

    public String getGosNomer() {
        return gosNomer;
    }

    public void setGosNomer(String gosNomer) {
        this.gosNomer = gosNomer;
    }

    public double getProbeg() {
        return probeg;
    }

    public void setProbeg(double probeg) {
        this.probeg = probeg;
    }

}

//Легковой автомобиль
class PassengerCar extends Car{
    private int codeCar;
    private double typeToplivo;
    private double rashodToplivo;
    private String gosNomer;
    private double probeg;
    public static double sizeGsm = 0.0;
    public static int count = 0; //увеличивается в конструкторе на 1 при создании экземпляра класса, необходим при создании массива

    //Конструктор, при создании экземпляра класса расчитывается расход за ГСМ и добавляется в статическую переменную класса
    public PassengerCar(int codeCar, String gosNomer, double probeg, double typeToplivo, double rashodToplivo) {
        this.codeCar = codeCar;
        this.gosNomer = gosNomer;
        this.probeg = probeg;
        this.typeToplivo = typeToplivo;
        this.rashodToplivo = rashodToplivo;
        sizeGsm += (double) (((probeg / 100) * rashodToplivo) * typeToplivo);
        count+=1;
    }


    static String getSizeGsm(){
        return "ТипАвто-100: " + String.valueOf(sizeGsm)+"\n";
    }

    @Override
    public String toString() {
        return "ТипАвто=" + codeCar +
                ", ГосНомер='" + gosNomer + '\'' +
                ", Пробег=" + probeg;
    }
}

//Грузовой авто
class Truck extends Car {
    private int codeCar;
    private double typeToplivo;
    private double rashodToplivo;
    private int dopParameter;
    private String gosNomer;
    private double probeg;
    public static double sizeGsm = 0.0;
    public static int count = 0;

    public Truck(int codeCar, String gosNomer,double probeg, int dopParameter, double typeToplivo, double rashodToplivo) {
        this.codeCar = codeCar;
        this.gosNomer = gosNomer;
        this.probeg = probeg;
        this.typeToplivo = typeToplivo;
        this.rashodToplivo = rashodToplivo;
        this.dopParameter = dopParameter;
        sizeGsm += (double) (((probeg / 100) * rashodToplivo) * typeToplivo);
        count += 1;
    }

    static String getSizeGsm(){
        return "ТипАвто-200: " + String.valueOf(sizeGsm)+"\n";
    }

    @Override
    public String toString() {
        return "ТипАвто=" + codeCar +
                ", ГосНомер='" + gosNomer + '\'' +
                ", Пробег=" + probeg +
                ", ДопПараметр=" + dopParameter;
    }
}

//Пассажирский автомобиль
class Bus extends Car {
    private int codeCar;
    private double typeToplivo;
    private double rashodToplivo;
    private int dopParameter;
    private String gosNomer;
    private double probeg;
    public static double sizeGsm = 0.0;
    public static int count = 0;

    public Bus(int codeCar, String gosNomer,double probeg, int dopParameter, double typeToplivo, double rashodToplivo) {
        this.codeCar = codeCar;
        this.gosNomer = gosNomer;
        this.probeg = probeg;
        this.typeToplivo = typeToplivo;
        this.rashodToplivo = rashodToplivo;
        this.dopParameter = dopParameter;
        sizeGsm += (double) (((probeg / 100) * rashodToplivo) * typeToplivo);
        count += 1;
    }

    static String getSizeGsm(){
        return "ТипАвто-300: " + String.valueOf(sizeGsm)+"\n";
    }

    @Override
    public String toString() {
        return "ТипАвто=" + codeCar +
                ", ГосНомер='" + gosNomer + '\'' +
                ", Пробег=" + probeg +
                ", ДопПараметр=" + dopParameter;
    }
}


class HeavyMachine extends Car {
    private int codeCar;
    private double typeToplivo;
    private double rashodToplivo;
    private int dopParameter;
    private String gosNomer;
    private double probeg;
    public static double sizeGsm = 0.0;
    public static int count = 0;

    public HeavyMachine(int codeCar, String gosNomer,double probeg, int dopParameter, double typeToplivo, double rashodToplivo) {
        this.codeCar = codeCar;
        this.gosNomer = gosNomer;
        this.probeg = probeg;
        this.typeToplivo = typeToplivo;
        this.rashodToplivo = rashodToplivo;
        this.dopParameter = dopParameter;
        sizeGsm += (double) (((probeg / 100) * rashodToplivo) * typeToplivo);
        count += 1;
    }
    static String getSizeGsm(){
        return "ТипАвто-400: " + String.valueOf(sizeGsm)+"\n";
    }

    @Override
    public String toString() {
        return  "ТипАвто=" + codeCar +
                ", Госномер='" + gosNomer + '\'' +
                ", Пробег=" + probeg +
                ", ДопПараметр=" + dopParameter;
    }
}
