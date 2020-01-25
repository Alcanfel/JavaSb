package Task22;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//Класс который генерирует нам данные для работы
public class CreateFile {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10 ; i++) {
            File file = new File(String.format("C:\\Users\\aitov-af\\IdeaProjects\\Project2021\\src\\Task22\\resources\\in_%s.dat", i));
            file.createNewFile();
            Files.write(Paths.get(String.valueOf(file)),String.valueOf(randomOperation()).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(String.valueOf(file)),("\n"+String.valueOf(randomNumber())+" " + String.valueOf(randomNumber())).getBytes(),StandardOpenOption.APPEND);

        }

        File file = new File("C:\\Users\\aitov-af\\IdeaProjects\\Project2021\\src\\Task22\\resources\\out.dat");
        file.createNewFile();
        Files.write(Paths.get(String.valueOf(file)),"0".getBytes());
    }

    private static int randomOperation() {
        return (int) (Math.random()*3)+1;
    }

    private static double randomNumber() {
        return (Math.random()*1000)+1;
    }
}
