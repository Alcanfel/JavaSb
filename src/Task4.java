import javax.sound.midi.Soundbank;

class Task4{
    public static void main(String[] args){
        System.out.println(simpleCalculate("2 + 2"));
        System.out.println(simpleCalculate("2 * 2"));
        System.out.println(simpleCalculate("2 / 2"));
        System.out.println(simpleCalculate("2 - 2"));
        System.out.println(hardCalculate("2 + 2 / 3 * 7"));

    }

    public static int simpleCalculate(String s) {
        String[] arrayStr = s.split(" ");
        int result = 0;
        switch (arrayStr[1]) {
            case "*": result+=Integer.parseInt(arrayStr[0])*Integer.parseInt(arrayStr[2]); break;
            case "/": result+=Integer.parseInt(arrayStr[0])/Integer.parseInt(arrayStr[2]); break;
            case "+": result+=Integer.parseInt(arrayStr[0])+Integer.parseInt(arrayStr[2]); break;
            case "-": result+=Integer.parseInt(arrayStr[0])-Integer.parseInt(arrayStr[2]); break;
            default: result = 0; break;
        }
        return result;


    }
    public static int hardCalculate(String s){
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
//        System.out.println(strres);
        return 0;
    }
}