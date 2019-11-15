package Task8_2;

//Необходимо реализовать класс в конструктор которого передается целочисленный массив.
//        Необходимо реализовать в данном классе следующие функции:
//        - добавление элемента в массив (в конец и в определенную позицию) + Доработать
//        - функцию вывод количества элементов в массиве +
//        - удаление элемента массива по индексу
//        - изменения значения по его индексу
//        - функция вывода на экран всего массива +
//        - функцию сортировки массива (по возрастанию и убыванию без изменения исходного массива)
//        - функцию вывода максимального/минимального элемента
//        - функцию заполнения массива одинаковыми элементами

public class Main {
    public static void main(String[] args) {
        int[] array = {10,20,1, 3, 54, 6,30,40,50,60};
        MyArray myArray = new MyArray(array);
        myArray.show();
        myArray.append(70);
        myArray.append(80);
        myArray.append(90);
        myArray.show();
        myArray.append(100, 0);
        myArray.show();
        myArray.append(200, 1);
        myArray.append(999, 5);
        myArray.append(300, 6);
        myArray.show();
        myArray.size();
        myArray.remove(5);
        myArray.show();
        myArray.remove(4);
        myArray.show();
        myArray.remove(10);
        myArray.show();
        myArray.remove(11);
        myArray.show();
        myArray.remove(9);
        myArray.show();
        myArray.remove(0);
        myArray.show();
        myArray.remove(-1);
        myArray.show();
        myArray.max();
        myArray.min();
        myArray.sortAsc();
        myArray.show();
        myArray.sortDesc();
        myArray.show();

    }
}
