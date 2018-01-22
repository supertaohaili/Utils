package www.thl.com.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommonUtils {

    /**
     * 解析List<Map<String,String>>集合
     *
     * @param key
     * @param jsonString
     * @return
     */
    public static List<Map<String, String>> parseListKeyMaps(String key, String jsonString) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(key);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                Map<String, String> map = new HashMap<String, String>();
                Iterator<String> iterator = jsonObject2.keys();
                while (iterator.hasNext()) {
                    String json_key = iterator.next();
                    Object json_value = jsonObject2.get(json_key);
                    if (json_value == null) {
                        json_value = "";
                    }
                    map.put(json_key, "" + json_value);
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 解析List<Map<String,String>>集合
     *
     * @param
     * @param jsonString
     * @return
     */
    public static List<Map<String, String>> parseListMaps(String jsonString) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                Map<String, String> map = new HashMap<String, String>();
                Iterator<String> iterator = jsonObject2.keys();
                while (iterator.hasNext()) {
                    String json_key = iterator.next();
                    Object json_value = jsonObject2.get(json_key);
                    if (json_value == null) {
                        json_value = "";
                    }
                    map.put(json_key, "" + json_value);
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 解析map 集合
     *
     * @param key
     * @param jsonString
     * @return
     */
    public static HashMap<String, String> parseMaps(String key, String jsonString) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String string = jsonObject.getString(key);
            JSONObject jsonObject2 = new JSONObject(string);
            Iterator<String> iterator = jsonObject2.keys();
            while (iterator.hasNext()) {
                String json_key = iterator.next();
                Object json_value = jsonObject2.get(json_key);
                if (json_value == null) {
                    json_value = "";
                }
                map.put(json_key, "" + json_value);
            }
        } catch (Exception e) {
        }
        return map;
    }


    /**
     * 解析map 集合
     *
     * @param jsonString
     * @return
     */
    public static HashMap<String, String> parseMaps(String jsonString) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            JSONObject jsonObject2 = new JSONObject(jsonString);
            Iterator<String> iterator = jsonObject2.keys();
            while (iterator.hasNext()) {
                String json_key = iterator.next();
                Object json_value = jsonObject2.get(json_key);
                if (json_value == null) {
                    json_value = "";
                }
                map.put(json_key, "" + json_value);
            }
        } catch (Exception e) {
        }
        return map;
    }
}
