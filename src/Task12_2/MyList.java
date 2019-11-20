package Task12_2;

public interface MyList {
    // Добавление эдемента в конец
    void appendLast(Integer value);

    // Добавление по индексу
    void appendPosition(Integer value, Integer position);

    // Добавление в начало
    void appendFirst(Integer value);

    // Вывести элементы списка
    void show();

    // Показать размер списка
    void size();

    // Заменить значение по индексу
    void replace(Integer value, Integer index);

    // Удалить значение по индексу
    void remove(Integer index);

    // Вывести максимальное значение
    void max();

    // Вывести минимальное значение
    void min();

}
