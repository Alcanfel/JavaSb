package Task1419.Task3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Collection<String> arra = new ArrayList();
        arra.add("Java");
        arra.add("Java");
        arra.add("Python");
        arra.add("Python");
        arra.add("Scala");
        arra.add("Kotlin");
        arra.add("Kotlin");
        arra.add("C++");
        arra.add("C#");
        arra.add("C");
        for (String i:arra
        ) {
            System.out.print(i+" ");
        }
        System.out.println();

        for (String i: Main.removeDuplicates(arra)
        ) {
            System.out.print(i+" ");
        }
    }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection){
        Collection<T> set = new HashSet<>(collection);
        return set;
    }
}
