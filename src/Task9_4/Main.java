package Task9_4;

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        //Вычислить выражение (вводить через пробел)
        c.calculate("2 + 2");
        c.calculate("2 - 5");
        c.calculate("2 * 10");
        c.calculate("56 / 2");
        c.calculate("100 / 2");

        //Возврат к последнему выражению
        c.getLastCalculate();

        //Показать историю вычислений
        c.getHistory();

        //Очистить историю
        c.clearCalculate();

        c.getHistory();
        c.getLastCalculate();




    }

}
