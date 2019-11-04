class Task3 {
    public static void main(String[] args) {
        String s = new String("Программирование это хорошо, но есть что-то лучше");
        char ch = 'о';
        int col = getCountChar(s, ch);
        //1 вариант
        System.out.format("Вариант№1\nИсходная строка: %s\nСимвол поиска: %c\nКоличество раз - %d, которое встречается данный символ\n\n", s, ch, col);

         //2 вариант
        int col2 = getCountCharV2(s ,ch);
        System.out.format("Вариант№2\nИсходная строка: %s\nСимвол поиска: %c\nКоличество раз - %d, которое встречается данный символ\n\n", s, ch, col2);
        System.out.format("Позиции: %s \n",getPositionChar(s, ch));


    }



    // 1 - Количество раз, которое встречается данный символ
    public static int getCountChar(String s, char ch) {
        char[] arrayChar = s.toCharArray();
        int countChar = 0;
        for (char temp : arrayChar) {
            if (temp == ch) {
                countChar += 1;
            }
        }
        return countChar;
    }

    // Еще один вариант реализации
    public static int getCountCharV2(String s, char ch) {
        String[] n = s.split(String.valueOf(ch));
        int result = n.length-1;
        return result;
    }

    // 2 - Дополнительное задание - вывести позиции этих символов

    public static StringBuilder getPositionChar(String s, char ch) {
        char[] arrayChar = s.toCharArray();
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < arrayChar.length; i++) {
            if (arrayChar[i] == ch) {
                positionString.append(i+1).append(" ");
            }

        }
        return positionString;
    }
}