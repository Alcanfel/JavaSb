package ReflectionAndAnnotation.Task2;

public class Calc {

    @Check(in1 = 5, in2 = 6, out = 11)
    @Check(in1 = 6, in2 = 6, out = 12)
    @Check(in1 = 7, in2 = 6, out = 13)
    @Check(in1 = 8, in2 = 6, out = 14)
    @Check(in1 = 9, in2 = 6, out = 15)
    @Check(in1 = 10, in2 = 6, out = 16)
    public static int summa(int val1, int val2){
        return val1 + val2;
    }

    @Check(in1 = 5, in2 = 6, out = -1)
    @Check(in1 = 6, in2 = 6, out = 0)
    @Check(in1 = 7, in2 = 6, out = 1)
    @Check(in1 = 8, in2 = 6, out = 2)
    @Check(in1 = 9, in2 = 6, out = 3)
    @Check(in1 = 10, in2 = 6, out = 4)
    @Check(in1 = 11, in2 = 6, out = 5)
    public static int diff(int val1, int val2){
        return val1 - val2;
    }

    @Check(in1 = 5, in2 = 6, out = 30)
    @Check(in1 = 5, in2 = 4, out = 20)
    @Check(in1 = 5, in2 = 3, out = 15)
    @Check(in1 = 5, in2 = 2, out = 10)
    @Check(in1 = 5, in2 = 1, out = 5)
    @Check(in1 = 5, in2 = -1, out = -5)
    @Check(in1 = 5, in2 = -2, out = -10)
    public static int multiplication(int val1, int val2){
        return val1 * val2;
    }

    @Check(in1 = 12, in2 = 6, out = 2)
    @Check(in1 = 12, in2 = 4, out = 3)
    @Check(in1 = 12, in2 = 2, out = 6)
    @Check(in1 = 12, in2 = -1, out = -12)
    @Check(in1 = 12, in2 = -2, out = -6)
    @Check(in1 = 12, in2 = -3, out = -4)
    @Check(in1 = 12, in2 = -6, out = -2)
    @Check(in1 = 12, in2 = -12, out = -1)
    public static int div(int val1, int val2){
        return val1 / val2;
    }
}
