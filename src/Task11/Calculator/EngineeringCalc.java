package Task11.Calculator;

public class EngineeringCalc extends Calculator {

    // Такие калькуляторы способны делать расчеты с приоритетами операций и скобками ....
    @Override
    public void calculate(String express) {
        this.count += 1;

        MyStack number = new MyStack(); // список для записи цифр
        MyStack znak = new MyStack(); // список для записи знаков

        String[] source = express.split(" ");


        for (int i = 0; i < source.length ; i++) { // в цикле перебираем массив символов
            // первая проверка на цифру, если цифра добавляем в список number
            if (isDigit(source[i])){
                number.push(String.valueOf(source[i]));
            }
            else // Если не цифра, работаем далее
                {
                    // Проверяем на пустоту списка znak, если пусто до добавляем, если нет, то проводим анализ далее
                if (znak.isNull() || source[i].equals("(")){
                    znak.push(String.valueOf(source[i]));
                } else {
                    boolean a = true; // счетчик необходим для управления циклом
                    while (a){
                        int priorit_new = getprioritet(String.valueOf(source[i])); // достаем приоритет у анализируемого знака
                        if (znak.isNull()) { // проверяем список на пустоту, необходим для выхода из цикла, при последующих итерациях
                            znak.push(String.valueOf(source[i]));
                            a = false;
                        } else {
                            int prioritet_old = getprioritet(znak.printPop()); //узнаем приоритет у последнего знаечния в стеке, без извлечения знаечния

                            if (priorit_new == -5){
                                boolean b = true;
                                while(b){
                                    if (getprioritet(znak.printPop()) == -1){
                                        String znak_1 = znak.pop();
                                        b = false;
                                        a = false;
                                    } else {
                                        int el_1 = Integer.parseInt(number.pop());
                                        int el_2 = Integer.parseInt(number.pop());
                                        String znak_1 = znak.pop();
                                        number.push(calc(el_1,el_2,znak_1));
                                    }

                                }
                            }

                            else if (priorit_new>prioritet_old){ // если у анализируемого знака приоритет выше,  то добавлем его с список знак и выходим из цикла
                                znak.push(String.valueOf(source[i]));
                                a = false;
                            } else if (priorit_new<prioritet_old){ // если у анализируемого знака приоритет ниже,  то берем две последние цифры из списка цифр и последнйи знак в списке znak - проводим вычисления и добавляем в список цифры
                                int el_1 = Integer.parseInt(number.pop());
                                int el_2 = Integer.parseInt(number.pop());
                                String znak_1 = znak.pop();
                                number.push(calc(el_1,el_2, znak_1));
                            } else if (priorit_new == prioritet_old) { // если у анализируемого знака приоритет такой же,  то берем две последние цифры из списка цифр и последнйи знак в списке znak - проводим вычисления и добавляем в список цифры
                                int el_1 = Integer.parseInt(number.pop());
                                int el_2 = Integer.parseInt(number.pop());
                                String znak_1 = znak.pop();
                                number.push(calc(el_1,el_2,znak_1));
                            }
                        }
                    }
                }
            }
        }
        // После перебора массива символов, список знаки не пустой, необходимо провести все вычесления, чтобы список стал пустым.

        while (!znak.isNull()){
            int el_1 = Integer.parseInt(number.pop());
            int el_2 = Integer.parseInt(number.pop());
            String znak_1 = znak.pop();
            number.push(calc(el_1,el_2,znak_1));
        }
        this.result = Double.parseDouble(number.printPop());
        this.history.append(express).append(" = ").append(this.result).append("\n");


    }
    //Возвращает приоритет.
    // + - = 1
    // * / = 2
    private int getprioritet(String value){
        switch (value){
            case "+":{
                return 1;
            }
            case "-":{
                return 1;
            }
            case "*":{
                return 2;

            }
            case "/":{
                return 2;
            }
            case "(":{
                return -1;
            }
            case ")":{
                return -5;
            }
        }
        return 0;
    }

    //возвращает результат простого выражения
    public String calc(int val, int val2, String znak) {
        switch (znak) {
            case "+": {
                return String.valueOf(val+val2);
            }
            case "-": {
                return String.valueOf(val2-val);
            }
            case "*": {
                return String.valueOf(val*val2);
            }
            case "/": {
                return String.valueOf(val2/val);
            }
        }
        return null;
    }

    // Проверка на число
    boolean isDigit(String str){
        char[] chStr = str.toCharArray();
        boolean a = false;
        for (int i = 0; i <chStr.length ; i++) {
            a = Character.isDigit(chStr[i]);
        }
        return a;
    }
}
