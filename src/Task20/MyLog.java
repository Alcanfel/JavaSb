package Task20;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class MyLog {
    File file = null;
    public MyLog(){

    }
    public MyLog(String fileName) throws IOException {
        //Проверяем на существование файла
        if (Files.exists(Paths.get(fileName).toAbsolutePath())){
            this.file = new File(String.valueOf(Paths.get(fileName).toAbsolutePath()));
        } else {
            System.out.println("Файл не существует, создадим!");
            this.file = new File(String.valueOf(Paths.get(fileName).toAbsolutePath()));
            this.file.createNewFile();
        }
    }

    public void logAdd(String sc, String user) throws IOException {
        Files.write(Paths.get(String.valueOf(this.file)),new Date().toString().getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(String.valueOf(this.file)),"\t-".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(String.valueOf(this.file)),user.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(String.valueOf(this.file)),"\t-".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(String.valueOf(this.file)),sc.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(String.valueOf(this.file)),"\n".getBytes(), StandardOpenOption.APPEND);

    }
}
