package Task9_4;

public class Calculator {
    //Результат вычисления
    public double result = 0;

    //переменная для хранения истории
    private StringBuilder history = new StringBuilder();

    //счетчик который показывает количество вычислений
    public int count = 0;

    public Calculator() {

    }

    public void calculate(String express) {
        this.count += 1;
        switch (express.split(" ")[1]) {
            case "+": {
                this.result = Double.parseDouble(express.split(" ")[0]) + Double.parseDouble(express.split(" ")[2]);
                history.append(express).append(" = ").append(String.valueOf(this.result)).append("\n");
                break;
            }
            case "-": {
                this.result = Double.parseDouble(express.split(" ")[0]) - Double.parseDouble(express.split(" ")[2]);
                history.append(express).append(" = ").append(String.valueOf(this.result)).append("\n");
                break;
            }
            case "*": {
                this.result = Double.parseDouble(express.split(" ")[0]) * Double.parseDouble(express.split(" ")[2]);
                history.append(express).append(" = ").append(String.valueOf(this.result)).append("\n");
                break;
            }
            case "/": {
                this.result = Double.parseDouble(express.split(" ")[0]) / Double.parseDouble(express.split(" ")[2]);
                history.append(express).append(" = ").append(String.valueOf(this.result)).append("\n");
                break;
            }
        }
    }

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
