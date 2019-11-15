package Task8_2;

public class MyArray {
    private int[] myArray = new int[10];


    public MyArray(int[] b) {
        this.myArray = b.clone();
    }

    //    - добавление элемента в массив (в конец и в определенную позицию)
    public void append(int a) {
        int[] newArray = new int[this.myArray.length + 1];
        for (int i = 0; i < this.myArray.length; i++) {
            newArray[i] = this.myArray[i];
        }
        newArray[newArray.length - 1] = a;
        this.myArray = newArray.clone();
    }

    public void append(int element, int position) {
        if (this.myArray.length < position) {
            System.out.println("В массиве нет такой позиции");
        } else if (position < 1) {
            System.out.println("Позиция начинается с 1");
        } else {
            int[] newArray = new int[this.myArray.length + 1];
            int first_pos = 1;
            for (int i = 0; i < this.myArray.length; i++) {
                if (first_pos == position) {
                    newArray[i] = element;
                    break;
                }
                newArray[i] = this.myArray[i];
                first_pos += 1;
            }

            for (int i = position; i < newArray.length; i++) {
                newArray[i] = this.myArray[i - 1];
            }
            this.myArray = newArray.clone();
        }

    }

    //    функцию вывод количества элементов в массиве
    public void size() {
        System.out.printf("В массиве %d элементов\n", this.myArray.length);
    }


    // - функция вывода на экран всего массива
    public void show() {
        for (int temp : this.myArray
        ) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    //        - изменения значения по его индексу
    public void replace(int element, int index) {
        if (index >= this.myArray.length) {
            System.out.println("В массиве нет такого индекса");
        } else if (index < 0) {
            System.out.println("Индекс начинается с 0");
        } else {
            this.myArray[index] = element;
        }
    }

    public void remove(int index) {

        if (index > this.myArray.length - 1 || index < 0){
            System.out.println("Вы вышли за пределы индекса");
        } else {
            int[] prev = new int[this.myArray.length - 1];


            for (int i = 0, j = index; i < this.myArray.length -1 ; i++) {

                if (i == index) {
                    prev[prev.length-1] = this.myArray[this.myArray.length-1];

                } else if (i > index) {
                    prev[j] = this.myArray[i];
                    j++;
                } else {
                    prev[i] = this.myArray[i];
                }
            }
            this.myArray=prev.clone();
        }


    }

    public void max(){
        int i = this.myArray[0];
        for (int j = 1; j < this.myArray.length ; j++) {
            if (this.myArray[j] > i){
                i = this.myArray[j];
            }
        }
        System.out.println(i);
    }

    public void min(){
        int i = this.myArray[0];
        for (int j = 1; j < this.myArray.length ; j++) {
            if (this.myArray[j] < i){
                i = this.myArray[j];
            }
        }
        System.out.println(i);
    }

    //функция заполнения массива одинаковыми элементами
    public void writeAll(int element){
        for (int i = 0; i < this.myArray.length; i++) {
            this.myArray[i] = element;
        }
    }

    public void sortAsc(){
        for (int i = this.myArray.length-1; i >= 1 ; i--) {
            for (int j = 0; j < i ; j++) {
                if (this.myArray[j] > this.myArray[j+1]){
                    int elem = this.myArray[j];
                    this.myArray[j] = this.myArray[j+1];
                    this.myArray[j+1] = elem;
                }
            }
        }
    }

    public void sortDesc(){
        for (int i = this.myArray.length-1; i >= 1 ; i--) {
            for (int j = 0; j < i ; j++) {
                if (this.myArray[j] < this.myArray[j+1]){
                    int elem = this.myArray[j];
                    this.myArray[j] = this.myArray[j+1];
                    this.myArray[j+1] = elem;
                }
            }
        }
    }

}
