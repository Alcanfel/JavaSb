package Task11.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator c = new SimpleCalc();
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


        // Проверка работы Стэка
//        MyStack myStack = new MyStack();
//        myStack.push("12");
//        myStack.push("115");
//        myStack.push("200");
//        myStack.show();
//        System.out.println("Посл элемент " + myStack.pop());
//        myStack.show();
//        System.out.println("Посл элемент " + myStack.pop());
//        myStack.show();
//        System.out.println("Посл элемент " + myStack.pop());
//        myStack.show();
//        System.out.println("Посл элемент " + myStack.pop());

        Calculator engineering = new EngineeringCalc();
        engineering.calculate("1 + ( 2 * 3 + 4 / 2 ) * 2 / 4");
        engineering.calculate("( 10 * 34 ) / 2");
        engineering.calculate("( 2 + 3 ) * ( 3 / 3 )");

        engineering.getHistory();

        engineering.getLastCalculate();


    }
}
