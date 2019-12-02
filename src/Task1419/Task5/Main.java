package Task1419.Task5;

import javax.naming.spi.ObjectFactoryBuilder;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put(1, "100");
        map.put(2, "200");
        map.put(5, "200");
        map.put(3, "300");
        map.put(4, "300");




        Map<Object, Collection<Object> > newMap = reverse(map);

        for (Object temp: newMap.keySet()
             ) {
            System.out.println(temp + " " + newMap.get(temp));
        }
        
    }

    public static Map<Object, Collection<Object> > reverse(Map<Object, Object> map){
        Map<Object, Collection<Object>> newMap = new HashMap<>();

        for (Object key: map.keySet()
             ) {
            Collection<Object> newList = new ArrayList<>();
            if (!newMap.containsKey(map.get(key))){
                newList.add(key);
                newMap.put(map.get(key), newList);
            } else{
                Collection<Object> oldlist = (Collection<Object>) newMap.get(map.get(key));
                oldlist.add(key);
                newMap.put(map.get(key), oldlist);
            }

        }
        return newMap;
    }

}
