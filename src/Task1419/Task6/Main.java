package Task1419.Task6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] source = {"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};
        System.out.println("Победитель в этой игре: " + winner(source));
    }
    public static String winner(String[] source){
        Map<String, ArrayList> map = new HashMap<>();
        // Преобразуем массив в словарь вида:
        //Имя : [счет, количество шагов в игре )
//        Alex : [16, 15]
//        Petr : [16, 11]
//        Ivan : [12, 10]

        for (int i = 0; i < source.length; i++) {
            ArrayList<Integer> listValue = new ArrayList<>();
            if (!map.containsKey(source[i].split(" ")[0])){
                listValue.add(Integer.parseInt(source[i].split(" ")[1]));
                listValue.add(i+1);
                map.put(source[i].split(" ")[0], listValue);
            } else {
                ArrayList oldValue = map.get(source[i].split(" ")[0]);
                listValue.add((int)oldValue.get(0)+Integer.parseInt(source[i].split(" ")[1]));
                listValue.add(i+1);
                map.put(source[i].split(" ")[0],  listValue);
            }
        }
        return getWinner(map);
    }


    public static String getWinner(Map map){
        String player = null;
        Integer iter = 0;
        Integer size = 0;
        for (Object key: map.keySet()
             ) {
            if (size<((List<Integer> ) map.get(key)).get(0)){
                size = ((List<Integer> ) map.get(key)).get(0);
                iter = ((List<Integer> ) map.get(key)).get(1);
                player = String.valueOf(key);
            } else if (size == ((List<Integer> ) map.get(key)).get(0)){
                if (iter > ((List<Integer> ) map.get(key)).get(1)){
                    size = ((List<Integer> ) map.get(key)).get(0);
                    iter = ((List<Integer> ) map.get(key)).get(1);
                    player = String.valueOf(key);
                }
            }

        }
        return player;
    }
}
