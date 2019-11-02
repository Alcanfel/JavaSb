class Task3 {
    public static void main(String[] args) {
        String s = new String("Программирование это хорошо, но есть что-то лучше");
        char ch = 'н';
        int col = getCountChar(s, ch);
        System.out.format("Исходная строка: %s\nСимвол поиска: %c\nКоличество раз - %d, которое встречается данный символ\n", s, ch, col);

        StringBuilder positionString = getPositionChar(s, ch);
        System.out.println(positionString);
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

    // 2 - Дополнительное задание - вывести позиции этих символов

    public static StringBuilder getPositionChar(String s, char ch) {
        char[] arrayChar = s.toCharArray();
        StringBuilder positionString = new StringBuilder("Позиции:");
        for (int i = 0; i < arrayChar.length; i++) {
            if (arrayChar[i] == ch) {
                positionString.append(i+1).append(" ");
            }

        }
        return positionString;
    }
}