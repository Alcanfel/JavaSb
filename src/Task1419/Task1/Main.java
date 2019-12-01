package Task1419.Task1;

import Task11.Auto.CompleteCar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] source = {
                "C100_1-100",
                "C200_1-120-1200",
                "C300_1-120-30",
                "C400_1-80-20",
                "C100_2-50",
                "C200_2-40-1000",
                "C300_2-200-45",
                "C400_2-10-20",
                "C100_3-10",
                "C200_3-170-1100",
                "C300_3-150-29",
                "C400_3-100-28",
                "C100_1-300",
                "C200_1-100-750",
                "C300_1-32-15"};
        //Создание массива экземпляров классов наследников Car
        List<Car> listCar =Complete.creatArrayObjectReferenceCar(source);

        ////Общую стоимость расходов на ГСМ, так и расходы на каждый класс авто
        Complete.getTotalAndGroupCarGsm(listCar);
        System.out.println();
        //тип авто имеющий наибольшую стоимость расходов
        System.out.println(Complete.getCodeCarMaxRashod(listCar));
        System.out.println();
        //тип авто имеющий наименьшей стоимость расходов
        System.out.println(Complete.getCodeCarMinRashod(listCar));
        System.out.println();
        //реализовать функции которые в разрезе каждого типа авто выводят информацию о каждом авто (тип, номер, пробег, доп. параметр), с сортировкой по пробегу и доп параметру.
        Complete.printInfo(listCar);
    }



}
