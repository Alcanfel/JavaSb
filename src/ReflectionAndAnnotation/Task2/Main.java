package ReflectionAndAnnotation.Task2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> calc = Class.forName("ReflectionAndAnnotation.Task2.Calc");
        Method[] methods = calc.getDeclaredMethods();
        for (Method method: methods
             ) {
            MyRepeatedCheck annotations = method.getAnnotation(MyRepeatedCheck.class);
            for (Annotation check: annotations.value()
                 ) {
                Check checkUnique = (Check) check;
                int i = (int) method.invoke(null, checkUnique.in1(), checkUnique.in2() );
            if (i == checkUnique.out()){
                System.out.println(method.getName() + " Проверка пройдена");
            } else {
                System.out.println(method.getName() + "Проверка не пройдена");
//            }
            }
            }
        }
    }
}

