package Task1419.Task5;

import javax.naming.spi.ObjectFactoryBuilder;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put(1, "100");
        map.put(2, "200");
        map.put(3, "300");
        map.put(4, "400");

        Map<Object, Object> newMap = reverse(map);

        for (Object temp: newMap.keySet()
             ) {
            System.out.println(temp + " " + newMap.get(temp));
        }
        
    }

    public static Map<Object, Object> reverse(Map<Object, Object> map){
        Map<Object, Object> newMap = new HashMap<>();

        for (Object key: map.keySet()
             ) {
            newMap.put(map.get(key), key);
        }
        return newMap;
    }

}
