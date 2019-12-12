package Task20;

public enum MyPathFile {
    USER ("C:\\Users\\aitov-af\\IdeaProjects\\TaskPart2\\src\\NewTask\\User.txt","/home/attenuator/IdeaProjects/JavaSb/src/Task20/User.txt"),
    DATACAR ("C:\\Users\\aitov-af\\IdeaProjects\\TaskPart2\\src\\NewTask\\DataCar.txt","/home/attenuator/IdeaProjects/JavaSb/src/Task20/DataCar.txt"),
    PRICEFUEL ("C:\\Users\\aitov-af\\IdeaProjects\\TaskPart2\\src\\NewTask\\PriceFuel.txt","/home/attenuator/IdeaProjects/JavaSb/src/Task20/PriceFuel.txt"),
    RATEFUEL ("C:\\Users\\aitov-af\\IdeaProjects\\TaskPart2\\src\\NewTask\\RateFuel.txt","/home/attenuator/IdeaProjects/JavaSb/src/Task20/RateFuel.txt");

    private String pathWindow;
    private String pathUbuntu;

    MyPathFile(String pathWindow, String pathUbuntu ){
        this.pathWindow = pathWindow;
        this.pathUbuntu = pathUbuntu;
    }

    public String getPathWindow() {
        return pathWindow;
    }

    public String getPathUbuntu() {
        return pathUbuntu;
    }
}
