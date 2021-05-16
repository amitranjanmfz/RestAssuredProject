package helpers;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class KeyValueAssertUtil {
    public static Map<String,String> assertionSplit(String assertion) {
        Map<String,String> keyValueMap = new HashMap<>();
        if(StringUtils.isNotBlank(assertion)) {
            String[] keyValuePairs = assertion.split("\\|");
            for(String pair:keyValuePairs) {
                String[] temp=pair.split(":");
                if(temp[1].equals("\"\"")) {
                    keyValueMap.put(temp[0],"");
                } else {
                    keyValueMap.put(temp[0],temp[1]);
                }
            }
        }
        return  keyValueMap;
    }

    public static String parse(JSONObject json1, Map<String,String> keyMap) {
        String currPath="$";
        Map<String,String> keyMapCopy = new HashMap<>(keyMap);
        JSONObject resultJson = parse(json1,keyMapCopy,currPath,new JSONObject("{}"));
        if(!keyMapCopy.isEmpty()) {
            for (String expectedKey: keyMapCopy.keySet()) {
                if(!keyMapCopy.get(expectedKey).equals("KEY_SHOULD_BE_MISSING")) {
                    resultJson.put(expectedKey,"Field not found");
                }
            }
        }
        return  resultJson.toString();
    }

    private static JSONObject parse(JSONObject json1,  Map<String,String> keyMap,String path, JSONObject resultJson) {
        Set<String> keyStrings = new HashSet<>();
        keyStrings.addAll(json1.keySet());
        Iterator<String> keys = keyStrings.iterator();
        while (keys.hasNext() && !keyMap.isEmpty()) {
            String key1=keys.next();
            String currPath = path + "." +key1;
            if(json1.get(key1) instanceof  JSONObject) {
                JSONObject value1 = json1.getJSONObject(key1);
                parse(value1,keyMap,currPath,resultJson);
            } else if(json1.get(key1) instanceof JSONArray) {
                //parse(json1,key1,(JSONArray) json1.get(key1),keyMap,currPath,resultJson);
            } else {
                //checkKeyValuePair(json1, keyMap, currPath, resultJson, key1);
            }
        }

        return  resultJson;
    }


}
