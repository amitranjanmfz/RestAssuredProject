package helpers;

import org.json.JSONArray;
import org.json.JSONObject;
import java.math.BigDecimal;
import java.util.*;

public class JsonCreator {

    private static final String DELIMITER="\\|";

    public static String transformData(String value)
    {
        if(value!=null && value.toLowerCase().startsWith("dg:")){
            String[] parts = value.split(":");
            try{
                //Method method=DataGenerator.class.getMethod(parts[1]);
                //return (String) method.invoke(null);
            }catch (Exception e){
                //Assert.fail(e.getMessage());
            }
        }
        return value;
    }

    public static JSONObject parse(JSONObject json1,Object[] colNames,Object[] values){
        Map<String, LinkedList<String>> keyMap = new HashMap<>();
        for(int i=0;i<colNames.length;i++) {
            if(keyMap.containsKey(colNames[i])) {
                keyMap.get(colNames[i]).add((String)values[i]);
            }else {
                LinkedList<String> vals = new LinkedList<>();
                vals.add((String)values[i]);
                keyMap.put((String)colNames[i],vals);
            }
        }
        JSONObject obj = parse(json1,keyMap);
        keyMap.clear();
        return obj;
    }

    public static JSONObject parse(JSONObject json1,String[] colNames,String[] values){
        Map<String, LinkedList<String>> keyMap = new HashMap<>();
        for(int i=0;i<colNames.length;i++) {
            if(keyMap.containsKey(colNames[i])) {
                keyMap.get(colNames[i]).add((String)values[i]);
            }else {
                LinkedList<String> vals = new LinkedList<>();
                vals.add((String)values[i]);
                keyMap.put((String)colNames[i],vals);
            }
        }
        JSONObject obj = parse(json1,keyMap);
        keyMap.clear();
        return obj;
    }

    public static JSONObject parse(JSONObject json1,Map<String, LinkedList<String>> keyMap){
        Set<String> keyStrings = new HashSet<>(json1.keySet());
        Iterator<String> keys = keyStrings.iterator();
        while (keys.hasNext() && !keyMap.isEmpty()) {
            String key1 = keys.next();
            if(json1.get(key1) instanceof JSONObject) {
                JSONObject value1 = json1.getJSONObject(key1);
                parse(value1,keyMap);
            } else if (json1.get(key1) instanceof JSONArray) {
                parse((JSONArray) json1.get(key1),key1,keyMap);
            } else {
                if(keyMap.containsKey(key1)) {
                    insertElement(json1,key1,keyMap);
                    if(keyMap.get(key1).isEmpty()) {
                        keyMap.remove(key1);
                    }
                }
            }
        }
        return  json1;
    }

    private static JSONArray parse(JSONArray jsonArr,String lastKey,Map<String, LinkedList<String>> keyMap) {
        for(int i=0;i< jsonArr.length();i++) {
            Object o = jsonArr.get(i);
            if(o instanceof JSONObject) {
                parse((JSONObject) o,keyMap);
            } else if(o instanceof  JSONArray) {
                parse((JSONArray) o,lastKey,keyMap);
            } else {
                if(keyMap.containsKey(lastKey)) {
                    insertElements(jsonArr,lastKey,keyMap);
                    if(keyMap.get(lastKey).isEmpty()) {
                        keyMap.remove(lastKey);
                    }
                }
                return jsonArr;
            }
        }
        return jsonArr;
    }
    public static JSONObject jsonReader(String filename) {
        String content =FileHelper.readFile(filename);
        return  new JSONObject(content);
    }

    private  static void insertElement(JSONObject json,String key,Map<String, LinkedList<String>> keyMap) {
        Object obj=json.get(key);
        String value=keyMap.get(key).poll();
        if(value.length()>0){
            if(value.equals("NULL")){
                json.put(key,JSONObject.NULL);
            }else if(value.equals("REMOVE_KEY")){
                json.remove(key);
            }else if(obj instanceof Number){
                json.put(key,new BigDecimal(value));
            }else if(obj instanceof Boolean){
                json.put(key,Boolean.parseBoolean(value));
            }else{
                json.put(key,transformData(value));
            }

        }

    }
    private  static void insertElements(JSONArray jsonArr,String colName,Map<String, LinkedList<String>> keyMap) {
        Object obj=jsonArr.get(0);
        clearJsonArray(jsonArr);
        String[] listItems=keyMap.get(colName).poll().split(DELIMITER);
        if(obj instanceof Number){
            for(String item:listItems){
                jsonArr.put(new BigDecimal(item));
            }
        }else if(obj instanceof Boolean){
            for(String item:listItems){
                jsonArr.put(Boolean.parseBoolean(item));
            }
        }else{
            for(String item:listItems){
                jsonArr.put(item);
            }
        }

    }
    private static void clearJsonArray(JSONArray jsonArr){
        int startlen=jsonArr.length();
        for(int i=startlen-1;i>=0;i--){
            jsonArr.remove(i);
        }
    }

    public static String[] getJsonRequestKeySet(Map data)
    {
        return convert(data.keySet());
    }

    public static String[] getJsonRequestValueSet(Map data)
    {
        return Arrays.stream(data.values().toArray()).toArray(String[]::new);
    }

    public static String[] convert(Set<String> setOfString)
    {

        // Create String[] of size of setOfString
        String[] arrayOfString = new String[setOfString.size()];

        // Copy elements from set to string array
        // using advanced for loop
        int index = 0;
        for (String str : setOfString)
            arrayOfString[index++] = str;

        // return the formed String[]
        return arrayOfString;
    }
    /*private static void replaceEncryptedFields(JSONObject doc,Set<String> encryptedFields){

    }*/


}
