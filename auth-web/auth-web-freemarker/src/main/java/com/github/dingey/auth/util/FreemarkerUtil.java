package com.github.dingey.auth.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerUtil {
    private FreemarkerUtil() {
    }

    public static Map<String, String> toStringKeyValue(Map<?, ?> map, String valueProp) {
        Map<String, String> m = new HashMap<>();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object v = entry.getValue();
            if (valueProp != null && v != null) {
                if (v instanceof Map) {
                    v = ((Map) v).get(valueProp);
                } else {
                    try {
                        PropertyDescriptor pd = new PropertyDescriptor(valueProp, v.getClass());
                        v = pd.getReadMethod().invoke(v, new Object[0]);
                    } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            m.put(String.valueOf(entry.getKey()), String.valueOf(v == null ? "" : v));
        }
        return m;
    }

    public static Map<String, String> toStringKeyValue(Map<?, ?> map) {
        return toStringKeyValue(map, null);
    }
}
