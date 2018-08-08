package com.myke.mybatis.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author： zhangjianbin <br/>
 * ===============================
 * Created with IDEA.
 * Date： 2018/8/8
 * Time： 15:45
 * ================================
 */
public class ContextDbMap {
    private static Map<String, Object> dsMap = new ConcurrentHashMap<>(5);

    public static void put(String key, Object value) {
        dsMap.put(key, value);
    }

    public static boolean get(String key) {
        return dsMap.containsKey(key);
    }

    public static Map getDsMap() {
        return dsMap;
    }
}
