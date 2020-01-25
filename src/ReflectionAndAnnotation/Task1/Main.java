package ReflectionAndAnnotation.Task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        // Создаем экземпляры User
        User tester = new User("lego","pupkin-kl","Пупкин К.Л.", 0121312312);
        User buhgalter = new User("orehov-af","Орехов А.Ф.", 122211212);
        User developer = new User("maksimov-lp","Максимов Л.П.", 23554121);
        User oper = new User("piyakin-ev", 124544545);
        User  director = new User("nikolaeb-lm","Николаев Л.М.", 1245445452);

        //Складываем в лист для дальнейшего перебора
        List<User> users = new ArrayList<>();
        users.add(tester);
        users.add(buhgalter);
        users.add(developer);
        users.add(oper);
        users.add(director);

        // Данные будем запаковывать в словарь
        Map<String, Map> typeJSON = new HashMap<>();
        for (User user: users
             ) {
            //Содаем словарь для value словаря
            Map<String, String> valueJson = new HashMap<>();
            //Получаем класс User
            Class<?> cl = user.getClass();
            //Извлекаем масив всех полей класса
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields // Перебираем массив
            ) {

                if (field.getAnnotation(Parse.class).property()) { // проверяем возможность/невозможность добавления в json
                    field.setAccessible(true); // для не public полей разрешаем работу
                    if (field.get(user) == null) { // Если значение пустое, то проверяем на разрешение добавления нуловых значений
                        if (field.getAnnotation(Parse.class).visibility()) {
                            valueJson.put(field.getAnnotation(Parse.class).name(), "null");
                        }
                    } else {
                        valueJson.put(field.getAnnotation(Parse.class).name(), field.get(user).toString());
                    }

                }
            }
            typeJSON.put(cl.getDeclaredField("tab").get(user).toString(), valueJson);
        }

        //Преобразуем словарь в формат json
        ParseUtil.printJson(typeJSON);
    }
    }