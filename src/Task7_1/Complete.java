package Task7_1;

public class Complete {
    public static Object[] creatArrayObjectReferenceCar(String[] source){
        Object[] array_object = new Object[source.length]; //создаем массив объектов с длиной переданного массива строк
        for (int i = 0; i < source.length ; i++) {

            //Разбираем строки по значениям и создаем объекты классов наследников Car
            switch (Integer.parseInt(source[i].split("-")[0].split("_")[0].substring(1))){
                case 100:{
                    array_object[i] = new PassengerCar(source[i].split("-")[0].split("_")[1], Double.parseDouble(source[i].split("-")[1]));
                    break;
                }
                case 200:{
                    array_object[i] = new Truck(source[i].split("-")[0].split("_")[1], Double.parseDouble(source[i].split("-")[1]), Integer.parseInt(source[i].split("-")[2]));
                    break;
                }
                case 300:{
                    array_object[i] = new Bus(source[i].split("-")[0].split("_")[1], Double.parseDouble(source[i].split("-")[1]), Integer.parseInt(source[i].split("-")[2]));
                    break;
                }
                case 400:{
                    array_object[i] = new HeavyMachine(source[i].split("-")[0].split("_")[1], Double.parseDouble(source[i].split("-")[1]),Integer.parseInt(source[i].split("-")[2]));
                    break;
                }
            }
        }
        return array_object;
    }
}