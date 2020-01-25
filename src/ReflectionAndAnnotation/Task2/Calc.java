package ReflectionAndAnnotation.Task2;

public class Calc {

    @Check(in1 = 5, in2 = 6, out = 11)
    @CheckA(in1 = 20, in2 = 11, out = 31)
    public static int summa(int val1, int val2){
        return val1 + val2;
    }

    @Check(in1 = 5, in2 = 6, out = -1)
    @CheckA(in1 = 20, in2 = 11, out = 9)
    public static int diff(int val1, int val2){
        return val1 - val2;
    }

    @Check(in1 = 5, in2 = 6, out = 30)
    @CheckA(in1 = 20, in2 = 11, out = 220)
    public static int multiplication(int val1, int val2){
        return val1 * val2;
    }

    @Check(in1 = 12, in2 = 6, out = 2)
    @CheckA(in1 = 30, in2 = 10, out = 3)
    public static int div(int val1, int val2){
        return val1 / val2;
    }
}
