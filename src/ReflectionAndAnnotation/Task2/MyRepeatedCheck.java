package ReflectionAndAnnotation.Task2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Контейнерная аннотация
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatedCheck {
    Check[] value();
}
