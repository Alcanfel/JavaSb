package Task22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Result {
    private double value;

    public Result(Double value){
        this.value = value;
    }

    //Добавляем в результатирующую переменную
    void add(Double value){
        this.value += value;
    }

    Double getValue(){
        return this.value;
    }
    void putFile() throws IOException {
        Files.write(Paths.get("/home/attenuator/IdeaProjects/JavaSb/src/Task22/resources/out.dat"),
                            String.valueOf(this.getValue()).getBytes());
    }
}
