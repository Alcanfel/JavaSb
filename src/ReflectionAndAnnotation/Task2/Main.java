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
            Check check = method.getAnnotation(Check.class);
            CheckA checkA = method.getAnnotation(CheckA.class);

           int i = (int) method.invoke(null, check.in1(), check.in2() );
           int j = (int) method.invoke(null, checkA.in1(),checkA.in2());
            if (i == check.out() && j == checkA.out()){
                System.out.println("Проверка пройдена");
            } else {
                System.out.println("Проверка не пройдена");
            }
    }
        }
    }

