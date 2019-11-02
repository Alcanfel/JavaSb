import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task2 {
    public static void main(String[] args) {
        getReverse("Программирование это хорошо, но есть что-то лучше");
        System.out.println();
        //проверка:
        getReverse("Всем на свете это ясно —");
        getReverse("Быть программером прекрасно!");
        getReverse("Ты, программер, умный очень —");
        getReverse("Программируешь что хочешь!");
    }

    public static void getReverse(String str){
        String[] arrStr = str.split(" ");
        StringBuilder resStr = new StringBuilder();
        Pattern pattern = Pattern.compile("[,?!.:]");
        //Ищем слова слова у которых знаки препинания в конце, извлекаем ззнак препинания и вставляем в начало с пробелом
        for (int i = 0; i < arrStr.length; i++) {
            Matcher matcher = pattern.matcher(arrStr[i]);
            while (matcher.find()) {
                StringBuilder prep = new StringBuilder(arrStr[i].substring(matcher.start(), matcher.end()));
                StringBuilder stringBuilder = new StringBuilder(arrStr[i].substring(0, matcher.start()));
                prep.append(" ").append(stringBuilder);
                arrStr[i]=String.valueOf(prep);
            }
        }
        //Формируем выражение с конца
        for (int i = 0; i < arrStr.length; i++) {
            resStr.append(arrStr[arrStr.length - 1 - i]).append(" ");
        }
        //Заменяем пробелы перед знаками препинания на пустую строку
        Pattern pattern2 = Pattern.compile("\\s(?=[,?!.])");
        Matcher matcher = pattern2.matcher(resStr);
        System.out.println(matcher.replaceAll(""));
    }
}