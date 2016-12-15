package com.qiukeke.annotations.utils;

import com.qiukeke.annotations.UnImplementedMethod;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by mudu on 2016/12/15.
 */
public class UnImplementedMethodUtil {

    public static Map<String, List<Map<String, String>>> scan(String prefix) {
        Set<Method> methods = AnnotationUtil.getAnnotatedMethod(prefix, UnImplementedMethod.class);

        Map<String, List<Map<String, String>>> map = new HashMap<>();

        for (Method method : methods) {
            String className = method.getDeclaringClass().getName();
            List<Map<String, String>> tmplist = map.get(className);
            if (tmplist == null || tmplist.isEmpty()) {
                tmplist = new ArrayList<>();
            }

            Map<String, String> classMap = new HashMap<>();
            classMap.put("method", method.getName());
            classMap.put("class", className);
            UnImplementedMethod unImplementedMethod = method.getAnnotation(UnImplementedMethod.class);
            classMap.put("reason", unImplementedMethod.value());
            classMap.put("responser", unImplementedMethod.responser());
            tmplist.add(classMap);
            map.put(className, tmplist);
        }
        return map;
    }
}
