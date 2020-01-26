package ReflectionAndAnnotation.Task1;

import java.util.Map;

public class ParseUtil {
    public static void printJson(Map map){
        Map mapNew = new java.util.HashMap<String, Map<String, String>>(Map.copyOf(map));
        StringBuilder json = new StringBuilder("{");
        for ( Object string: map.keySet()
        ) {
            mapNew.remove(string);
            json.append("'"+string+"':");
            Map<String, String> mapValue = (Map<String, String>) map.get(string);
            Map<String, String> mapValueCopy = new java.util.HashMap<>(Map.copyOf(mapValue));
            json.append("{");
            for (Object stringValue: mapValue.keySet()
                    ) {
                mapValueCopy.remove(stringValue);
                    if (mapValueCopy.isEmpty()){
                        json.append("'"+stringValue+"':'"+mapValue.get(stringValue)+"'}");
                    } else {
                        json.append("'"+stringValue+"':'"+mapValue.get(stringValue)+"',");
                    }
                }
            if (mapNew.isEmpty()){
                json.append("}");
            } else  json.append(",");
            }
        System.out.println(json);
        }
    }

