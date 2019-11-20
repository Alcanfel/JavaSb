package Task12_2;

public class MyArrayList implements MyList {
    private Integer[] myArray;

    public MyArrayList() {
    }

    public MyArrayList(Integer[] b) {
        this.myArray = b.clone();
    }


    public void appendLast(Integer a) {
        if (this.myArray == null) {
            this.myArray = new Integer[1];
            this.myArray[0] = a;

        } else {
            Integer[] newArray = new Integer[this.myArray.length + 1];
            for (int i = 0; i < this.myArray.length; i++) {
                newArray[i] = this.myArray[i];
            }
            newArray[newArray.length - 1] = a;
            this.myArray = newArray.clone();
        }
    }


    public void appendFirst(Integer value) {
        if (this.myArray == null) {
            this.myArray = new Integer[1];
            this.myArray[0] = value;

        } else {
            Integer[] newArray = new Integer[this.myArray.length + 1];
            newArray[0] = value;
            for (int i = 0; i < this.myArray.length; i++) {
                newArray[i + 1] = this.myArray[i];
            }
            this.myArray = newArray.clone();
        }
    }

    public void appendPosition(Integer element, Integer position) {
        //Если массив пустой, то добавляем в конец
        if (this.myArray == null) {
            this.appendLast(element);
        } else {
            if (this.myArray.length < position) {
                System.out.println("В массиве нет такой позиции");
            } else if (position < 1) {
                System.out.println("Позиция начинается с 1");
            } else {
                Integer[] newArray = new Integer[this.myArray.length + 1];
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

    }

    //    функцию вывод количества элементов в массиве
    public void size() {
        if (!this.isNull()) {
            System.out.printf("Размер списка: %d\n", this.myArray.length);
        }

    }


    // - функция вывода на экран всего массива
    public void show() {
        if (!this.isNull()) {
            for (Integer value : this.myArray
            ) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    //        - изменения значения по его индексу
    public void replace(Integer element, Integer index) {
        if (!this.isNull()) {
            if (index >= this.myArray.length) {
                System.out.println("В массиве нет такого индекса");
            } else if (index < 0) {
                System.out.println("Индекс начинается с 0");
            } else {
                this.myArray[index] = element;
            }
        }

    }

    public void remove(Integer index) {
        if (!this.isNull()) {
            if (index > this.myArray.length - 1 || index < 0) {
                System.out.println("Вы вышли за пределы индекса");
            } else {
                Integer[] prev = new Integer[this.myArray.length - 1];


                for (int i = 0, j = index; i < this.myArray.length - 1; i++) {

                    if (i == index) {
                        prev[prev.length - 1] = this.myArray[this.myArray.length - 1];

                    } else if (i > index) {
                        prev[j] = this.myArray[i];
                        j++;
                    } else {
                        prev[i] = this.myArray[i];
                    }
                }
                this.myArray = prev.clone();
            }
        }


    }

    public void max() {
        if (!this.isNull()) {
            int i = this.myArray[0];
            for (int j = 1; j < this.myArray.length; j++) {
                if (this.myArray[j] > i) {
                    i = this.myArray[j];
                }
            }
            System.out.println(i);
        }

    }

    public void min() {
        if (!this.isNull()) {
            int i = this.myArray[0];
            for (int j = 1; j < this.myArray.length; j++) {
                if (this.myArray[j] < i) {
                    i = this.myArray[j];
                }
            }
            System.out.println(i);
        }

    }

    //функция заполнения массива одинаковыми элементами
    public void writeAll(Integer element, Integer count) {
        if (this.myArray == null) {
            this.myArray = new Integer[count];
            for (int i = 0; i < this.myArray.length; i++) {
                this.myArray[i] = element;
            }
        } else {
            this.writeAll(element);
        }

    }

    public void writeAll(Integer value) {
        for (int i = 0; i < this.myArray.length; i++) {
            this.myArray[i] = value;
        }
    }

    public void sortAsc() {
        if (!this.isNull()) {
            for (int i = this.myArray.length - 1; i >= 1; i--) {
                for (int j = 0; j < i; j++) {
                    if (this.myArray[j] > this.myArray[j + 1]) {
                        int elem = this.myArray[j];
                        this.myArray[j] = this.myArray[j + 1];
                        this.myArray[j + 1] = elem;
                    }
                }
            }
        }

    }

    public void sortDesc() {
        if (!this.isNull()) {
            for (int i = this.myArray.length - 1; i >= 1; i--) {
                for (int j = 0; j < i; j++) {
                    if (this.myArray[j] < this.myArray[j + 1]) {
                        int elem = this.myArray[j];
                        this.myArray[j] = this.myArray[j + 1];
                        this.myArray[j + 1] = elem;
                    }
                }
            }
        }

    }

    private boolean isNull() {
        if (this.myArray == null) {
            System.out.println("Список пустой!");
            return true;
        } else return false;
    }
}