package Task22;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MyThread implements Runnable {
    int i;
    volatile File file;
//    volatile File file_out = new File("/home/attenuator/IdeaProjects/JavaSb/src/Task22/resources/out.dat");
    Result resultNumber;

    public MyThread(int i, Result resultNumber){
        this.i = i;
        this.file = new File(String.format("/home/attenuator/IdeaProjects/JavaSb/src/Task22/resources/in_%s.dat",i));
        this.resultNumber = resultNumber;
    }

    @Override
    public void run() { synchronized (resultNumber){
        try {
            List<String> list = Files.readAllLines(Paths.get(String.valueOf(this.file)));
//            List<String> list1 = Files.readAllLines(Paths.get(String.valueOf(this.file_out)));
            System.out.println(String.format("Поток %s",this.i));
            switch (list.get(0)){
                case "1":{
                    Double m = Double.parseDouble(list.get(1).split(" ")[0]) + Double.parseDouble(list.get(1).split(" ")[1]);
                    this.resultNumber.add(m);
                    break;
                }
                case "2":{
                    this.resultNumber.add(Double.parseDouble(list.get(1).split(" ")[0]) * Double.parseDouble(list.get(1).split(" ")[1]));
//                    Files.write(Paths.get("/home/attenuator/IdeaProjects/JavaSb/src/Task22/resources/out.dat"),
//                            String.valueOf(result).getBytes());
                    break;
                }
                case "3":{
                    this.resultNumber.add(Math.pow(Double.parseDouble(list.get(1).split(" ")[0]),2) + Math.pow(Double.parseDouble(list.get(1).split(" ")[1]),2));
//                    Files.write(Paths.get("/home/attenuator/IdeaProjects/JavaSb/src/Task22/resources/out.dat"),
//                            String.valueOf(result).getBytes());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    }
}
