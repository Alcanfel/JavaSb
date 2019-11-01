import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task2 {
    public static void main(String[] args) {
        String str = "Программирование это хорошо, но есть что-то лучше";
        String[] arrStr = str.split(" ");
        StringBuilder resStr = new StringBuilder();
        Pattern pattern = Pattern.compile("[,?!]");
        for (int i = 0; i < arrStr.length; i++) {
            Matcher matcher = pattern.matcher(arrStr[i]);
            while (matcher.find()) {
                StringBuilder prep = new StringBuilder(arrStr[i].substring(matcher.start(), matcher.end()));
                StringBuilder stringBuilder = new StringBuilder(arrStr[i].substring(0, matcher.start()));
                prep.append(" ").append(stringBuilder);
                arrStr[i]=String.valueOf(prep);
            }
        }

        for (int i = 0; i < arrStr.length; i++) {
            resStr.append(arrStr[arrStr.length - 1 - i]).append(" ");
        }

//        Pattern pattern_2 = Pattern.compile("[,]");
//        Matcher matcher = pattern_2.matcher(resStr);
//
//        while (matcher.find()) {
//            resStr.replace(matcher.start()-1, matcher.end(), "" );
//        }

        System.out.println(resStr);
    }
}