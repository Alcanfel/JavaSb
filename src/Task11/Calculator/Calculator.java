package Task11.Calculator;


public abstract class Calculator implements CalculatorMethod {
    //Результат вычисления
    public double result = 0;

    //переменная для хранения истории
    public StringBuilder history = new StringBuilder();

    //счетчик который показывает количество вычислений
    public int count = 0;

    public abstract void calculate(String express);

    //возврат к последнему вычисленному выражению
    public void getLastCalculate() {
        String res = new String(this.history);
        if (res.length() > 0)
        {
            String calc = res.split("\n")[this.count - 1];
            System.out.println("возврат к последнему вычисленному выражению: " + calc);
        } else {
            System.out.println("В истории нет выражений");
        }
    }

    //очитска всех выражений
    public void clearCalculate() {
        this.history = new StringBuilder();
    }

    //Показать историю вычислений
    public void getHistory(){
        if (this.history.length()>0) {
            System.out.println("История вычисления:");
            System.out.println(this.history);}
        else {
            System.out.println("История пуста!");
        }
    }

}
