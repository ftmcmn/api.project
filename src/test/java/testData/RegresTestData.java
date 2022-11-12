package testData;

import java.util.HashMap;
import java.util.Map;

public class RegresTestData {

    public Map<String,String>mapMethod(String name, String job){

        Map<String,String> map = new HashMap<>();

        if (name!=null) {
            map.put("name", name);
        }
        if (job!=null) {
            map.put("job", job);
        }

        return map;
    }
}
