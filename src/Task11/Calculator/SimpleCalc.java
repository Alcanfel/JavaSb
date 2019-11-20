package Task11.Calculator;


public class SimpleCalc extends Calculator {
    @Override
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
}
