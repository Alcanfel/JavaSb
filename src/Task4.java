import javax.sound.midi.Soundbank;
import java.util.Stack;

class Task4{
    public static void main(String[] args){
        simpleCalculate("2 + 2");
        simpleCalculate("2 * 6");
        simpleCalculate("8 / 2");
        simpleCalculate("10 - 2");
        hardCalculate("12 + 2 / 3 * 7");

    }

    public static void simpleCalculate(String s) {
        String[] arrayStr = s.split(" ");
        int result = 0;
        switch (arrayStr[1]) {
            case "*": result+=Integer.parseInt(arrayStr[0])*Integer.parseInt(arrayStr[2]); break;
            case "/": result+=Integer.parseInt(arrayStr[0])/Integer.parseInt(arrayStr[2]); break;
            case "+": result+=Integer.parseInt(arrayStr[0])+Integer.parseInt(arrayStr[2]); break;
            case "-": result+=Integer.parseInt(arrayStr[0])-Integer.parseInt(arrayStr[2]); break;
            default: result = 0; break;
        }
        System.out.format("Результат операции %s %s %s = %d\n", arrayStr[0],arrayStr[1], arrayStr[2], result);


    }
    public static void hardCalculate(String s){

        char[] arrayStr = s.replaceAll(" ", "").toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char temp: arrayStr
             ) {
            System.out.println(temp);

        }


//        String[] arrayStr = s.split(" ");
//        for (String temp: arrayStr){
//            System.out.println(temp);
//        }
//
//        StringBuilder strres= new StringBuilder();
//        int result = 0;
//
//        for(int i = 0; i < arrayStr.length; i++){
//            switch (arrayStr[i]){
//                case "*":
//                    result+= (Integer.parseInt(arrayStr[i-1]) * Integer.parseInt(arrayStr[i+1]));
//                    strres.append(result);
//                    break;
//                default:
//                    strres.append(arrayStr[i]);
//                    break;
//
//            }
//        }
//
    }
}