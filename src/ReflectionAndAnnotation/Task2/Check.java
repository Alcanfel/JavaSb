package ReflectionAndAnnotation.Task2;

import java.lang.annotation.*;

// Повторяющейся аннотация
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedCheck.class)
public @interface Check {
    int in1();
    int in2();
    int out();
}


