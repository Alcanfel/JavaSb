package ReflectionAndAnnotation.Task2;

public enum InOut {
    SUMMA(new String[]{"1 2 3","2 3 5", "3 3 6"}),
    DIFF(new String[]{"4 2 2","6 3 3","4 4 0"}),
    MULTI(new String[]{"2 2 6","6 6 36","4 4 16"}),
    DEL(new String[]{"4 2 2","6 3 2","4 4 1"});

    private String[] inOut;

    InOut(String[] strings) {
        this.inOut = strings;
    }


    public String[] getInOut() {
        return inOut;
    }
}
