package Task11.Auto;

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
        Object[] arraySource = CompleteCar.creatArrayObjectReferenceCar(source);

        System.out.println("1. общая стоимость расходов на ГСМ, так и расходы на каждый класс авто");
        StringBuilder zadanie = CompleteCar.getTotalAndGroupCarGsm();
        System.out.println(zadanie);

        System.out.println("2. тип авто имеющий наибольшую стоимость расходов");
        String zadanie2 = CompleteCar.getCodeCarMaxRashod();
        System.out.println(zadanie2);


        System.out.println("3. тип авто имеющий наименьшую стоимость расходов");
        String zadanie3 = CompleteCar.getCodeCarMinRashod();
        System.out.println(zadanie3);

        System.out.println("4.реализовать функции которые в разрезе каждого типа авто выводят информацию о каждом авто (тип, номер, пробег, доп. параметр), с сортировкой по пробегу или доп параметру. ");
        CompleteCar.printInfo(arraySource);


    }
}
