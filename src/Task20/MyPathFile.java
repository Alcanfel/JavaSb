package Task20;

public enum MyPathFile {
    USER ("C:\\Users\\aitov-af\\IdeaProjects\\Project2021\\src\\Task20\\recources\\User.txt","/home/attenuator/IdeaProjects/JavaSb/src/Task20/recources/User.txt"),
    DATACAR ("C:\\Users\\aitov-af\\IdeaProjects\\Project2021\\src\\Task20\\recources\\DataCar.txt","/home/attenuator/IdeaProjects/JavaSb/src/Task20/recources/DataCar.txt"),
    PRICEFUEL ("C:\\Users\\aitov-af\\IdeaProjects\\Project2021\\src\\Task20\\recources\\PriceFuel.txt","/home/attenuator/IdeaProjects/JavaSb/src/Task20/recources/PriceFuel.txt"),
    RATEFUEL ("C:\\Users\\aitov-af\\IdeaProjects\\Project2021\\src\\Task20\\recources\\RateFuel.txt","/home/attenuator/IdeaProjects/JavaSb/src/Task20/recources/RateFuel.txt");

    private String pathWindow;
    private String pathUbuntu;

    MyPathFile(String pathWindow, String pathUbuntu ){
        this.pathWindow = pathWindow;
        this.pathUbuntu = pathUbuntu;
    }

    public String getPathWindow() {
        return pathUbuntu;
    }

    public String getPathUbuntu() {
        return pathUbuntu;
    }
}
