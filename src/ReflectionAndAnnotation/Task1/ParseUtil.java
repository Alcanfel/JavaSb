package ReflectionAndAnnotation.Task1;

import java.util.Map;

public class ParseUtil {
    public static void printJson(Map map){
        StringBuilder json = new StringBuilder("{");
        Integer razmer = map.keySet().size();
        Integer iter = 1;
        for ( Object string: map.keySet()
        ) {
            if (iter.equals(razmer)){
                json.append("'"+string+"':");
                Map<String, String> mapValue = (Map<String, String>) map.get(string);
                Integer razmerValue = mapValue.keySet().size();
                Integer iterValue = 1;
                json.append("{");
                for (Object stringValue: mapValue.keySet()
                ) {
                    if (iterValue.equals(razmerValue)){
                        json.append("'"+stringValue+"':'"+mapValue.get(stringValue)+"'}");
                    } else {
                        json.append("'"+stringValue+"':'"+mapValue.get(stringValue)+"',");
                    }
                    iterValue++;
                }
                json.append("}");
            } else{
                json.append("'"+string+"':");
                Map<String, String> mapValue = (Map<String, String>) map.get(string);
                Integer razmerValue = mapValue.keySet().size();
                Integer iterValue = 1;
                json.append("{");
                for (Object stringValue: mapValue.keySet()
                     ) {
                    if (iterValue.equals(razmerValue)){
                        json.append("'"+stringValue+"':'"+mapValue.get(stringValue)+"'}");
                    } else {
                        json.append("'"+stringValue+"':'"+mapValue.get(stringValue)+"',");
                    }
                    iterValue++;
                }
                json.append(",");
            }
            iter++;
        }
        System.out.println(json);
    }
}
