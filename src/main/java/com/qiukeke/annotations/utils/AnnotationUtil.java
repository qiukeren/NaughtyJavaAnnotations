package com.qiukeke.annotations.utils;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mudu on 2016/12/15.
 */
public class AnnotationUtil {

    public static Set<Class> getAnnotatedClass(String packageName, final Class<?> type) {
        Set<Class<?>> classesTmp = getClassInPackage(packageName);
        Set<Class> classes = new HashSet<>();
        for (Class clazz : classesTmp) {
            if (clazz != null && clazz.isAnnotationPresent(type)) {
                classes.add(clazz);
            }
        }
        return classes;
    }


    public static Set<Class<?>> getClassInPackage(String packageName) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setScanners(new SubTypesScanner(false), new ResourcesScanner())
            .setUrls(
                ClasspathHelper.forPackage(packageName, ClasspathHelper.contextClassLoader(), ClasspathHelper.staticClassLoader())
            ).filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(packageName))));

        return reflections.getSubTypesOf(Object.class);
    }

    public static Set<Method> getAnnotatedMethod(String packageName, Class<? extends Annotation> clazz) {

        Set<Class<?>> classes = getClassInPackage(packageName);

        Set<Method> methods = new HashSet<>();

        for (Class clazzTmp : classes) {
            methods.addAll(getClassAnnotatedMethod(clazzTmp, clazz));
        }
        return methods;
    }

    private static Set<Method> getClassAnnotatedMethod(Class clazz, final Class<? extends Annotation> type) {
        final Set<Method> methods = new HashSet<>();

        while (clazz != null && clazz != Object.class) {
            final Set<Method> allMethods = new HashSet<Method>(Arrays.asList(clazz.getDeclaredMethods()));
            for (final Method method : allMethods) {
                if (method.isAnnotationPresent(type)) {
                    methods.add(method);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return methods;
    }


}
