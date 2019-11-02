import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        getStringView("A12");
        getStringView("Z12");
        getStringView("AA12");
        getStringView("AB12");
        getStringView("AZ12");
        getStringView("AZ2");
        getStringView("BA2");
        getStringView("BZ2");
        getStringView("CA2");
        getStringView("AZ100");
        getStringView("ZZ100");

    }

    public static void getStringView(String str) {
        //Шаблон по поиску двух групп (columns + rows)
        Pattern pattern = Pattern.compile("([A-Za-z]*)([0-9]*)");
        Matcher m = pattern.matcher(str);
        StringBuilder column = new StringBuilder();
        StringBuilder row = new StringBuilder();
        if (m.find()) {
            column.append(m.group(1));
            row.append(m.group(2));
        }
        int numberColumn = getNumberOfChar(column);
        System.out.format("номер строки %s, номер столбца %d\n", row, numberColumn);
    }

    public static int getNumberOfChar(StringBuilder s) {
        char[] columns = s.toString().toCharArray();
        int first = (int) 'A';
        int last = (int) 'Z';
        int start = last - first + 1;
        int result = 0;
        if (columns.length == 1) {
            result += ((int) columns[0] + 1 - first);

        } else if (columns.length == 2) {
                result += start * ((int) columns[0] + 1 - first) + ((int) columns[1] + 1 - first);

        } else {
            System.out.println("Необходимо реализовать если столбец больше 2 символов");
        }
        return result;
    }
}