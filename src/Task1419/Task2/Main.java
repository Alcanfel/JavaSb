package Task1419.Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "While The Python Language Reference describes the exact syntax and semantics of the Python language, this library reference manual describes the standard library that is distributed with Python. It also describes some of the optional components that are commonly included in Python distributions.\n" +
                "\n" +
                "Python’s standard library is very extensive, offering a wide range of facilities as indicated by the long table of contents listed below. The library contains built-in modules (written in C) that provide access to system functionality such as file I/O that would otherwise be inaccessible to Python programmers, as well as modules written in Python that provide standardized solutions for many problems that occur in everyday programming. Some of these modules are explicitly designed to encourage and enhance the portability of Python programs by abstracting away platform-specifics into platform-neutral APIs.\n" +
                "\n" +
                "The Python installers for the Windows platform usually include the entire standard library and often also include many additional components. For Unix-like operating systems Python is normally provided as a collection of packages, so it may be necessary to use the packaging tools provided with the operating system to obtain some or all of the optional components.\n" +
                "\n" +
                "In addition to the standard library, there is a growing collection of several thousand components (from individual programs and modules to packages and entire application development frameworks), available from the Python Package Index.";
        List<String> list = new ArrayList<>();
        // Создали список и добавили каждый элемент строки.
        for (char temp : text.toCharArray()
        ) {
            list.add(String.valueOf(temp));
        }

        //Создали словарь
        Map<String, Integer> map = new HashMap<>();
        for (String temp : list
        ) {
            //Перебираем каждый символ списка и проверяем на совпадение по шаблону (анг буква алфавита)
            if (temp.matches("[A-Za-z]")) {
                if (map.get(temp) == null) { // Если словарь с ключом буквы отсутствует, то добавляем в словарь ключ (буква) и 1
                    map.put(temp, 1);
                } else {
                    // в противном случае достаем значение, прибавляем 1 и записываем повторно
                    Integer a = map.get(temp);
                    map.put(temp, a + 1);
                }
            }
        }
        for (String key : map.keySet()
        ) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
