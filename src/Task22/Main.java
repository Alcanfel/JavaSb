package Task22;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

//    В директории лежат входные текстовые файлы, проименованные следующим образом: in_<N>.dat, где N - натуральное число.
//    Каждый файл состоит из двух строк. В первой строке - число, обозначающее действие, а во второй - числа с плавающей точкой, разделенные пробелом.
//    Действия могут быть следующими:
//            1 - сложение
//            2 - умножение
//            3 - сумма квадратов
//    Необходимо написать многопоточное приложение, которое выполнит требуемые действия над числами и сумму результатов запишет в файл out.dat.
//    Название рабочей директории передается в виде аргумента рабочей строки. В реализации приветствуется использование полиморфизма и паттернов проектирования.

    static Result result = new Result(0.0);
    public static void main(String[] args) throws IOException, InterruptedException {


        for (int i = 0; i < 10 ; i++) {
            MyThread myThread = new MyThread(i, result);
            Thread thread = new Thread(myThread);
            thread.start();
            thread.join();
        }
//        List<String> result = Files.readAllLines(Paths.get(String.valueOf("/home/attenuator/IdeaProjects/JavaSb/src/Task22/resources/out.dat")));

        System.out.println(result.getValue());
        result.putFile();
    }
}

