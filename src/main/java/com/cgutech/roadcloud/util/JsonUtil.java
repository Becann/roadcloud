package com.cgutech.roadcloud.util;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Becan on 2017/6/8.
 */
public class JsonUtil {

    public static Gson gson = new Gson();

    public static String toJson(Object src){
        return gson.toJson(src);
    }

    public static <T> T toBean(String json,Class<T> type){
        return gson.fromJson(json,type);
    }

    public static <T> List<T> toList(String json,Class<T> clz){
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        List<T> list  = new ArrayList<>();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, clz));
        }
        return list;
    }

    public static <T> Map<String, T> toMap(String json, Class<T> clz){
        Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String,JsonObject>>(){}.getType());
        Map<String, T> result = new HashMap<>();
        for(String key:map.keySet()){
            result.put(key,gson.fromJson(map.get(key),clz) );
        }
        return result;
    }

    public static Map<String, Object> toMap(String json){
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String,Object>>(){}.getType());
        return map;
    }
}
