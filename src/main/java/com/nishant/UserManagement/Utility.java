package com.nishant.UserManagement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@Deprecated
/**
 * All methods of this class have been implemented using the Mergeable interface.
 * Using reflection may add vulnerabilities to the code which were avoidable
 */
public class Utility {
    /**
     * Method to replace all objects of Object original with the
     * objects of Object replace which are not null.
     * Note that both Objects have to be of the same class and have to have both getter and setter methods.
     */
    public static Object merge(Object original, Object replace){
        HashMap<String,Boolean> map = new HashMap<>();
        if(original.getClass().equals(Integer.class)
                ||original.getClass().equals(Byte.class)
                ||original.getClass().equals(Short.class)
                ||original.getClass().equals(Character.class)
                ||original.getClass().equals(Long.class)
                ||original.getClass().equals(Float.class)
                ||original.getClass().equals(Double.class)
                ||original.getClass().equals(String.class)){
            return replace;
        }
        for(Method m : original.getClass().getMethods()){
            try {
                if(m.getName().startsWith("get")&&m.invoke(replace)!=null){
                    map.put(m.getName().substring(3),true);
                }
            } catch (Exception e) {
                System.out.println(m);
                System.out.println(e.getMessage());
            }
        }
        for(Method m : original.getClass().getMethods()){
            if(m.getName().startsWith("set")&&map.containsKey(m.getName().substring(3))){
                try {
                    Method getter = original.getClass().getMethod("get"+m.getName().substring(3));
                    m.invoke(original,merge(getter.invoke(original),getter.invoke(replace)));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return original;
    }
    public static <T> T mergeGPT(T original, T replace) {
        if (original == null) {
            return replace;
        }

        if (replace == null) {
            return original;
        }

        Class<?> clazz = original.getClass();

        try {
            T merged = (T) clazz.newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Object originalValue = field.get(original);
                Object replaceValue = field.get(replace);

                if (replaceValue != null) {
                    field.set(merged, replaceValue);
                } else if (originalValue != null) {
                    field.set(merged, originalValue);
                }
            }

            return merged;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return original; // Return the original object on error
        }
    }
    public static <T> T mergeGPT2(T original, T replace) {
        if (original == null) {
            return replace;
        }

        if (replace == null) {
            return original;
        }

        Class<?> clazz = original.getClass();

        try {
            T merged = (T) clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Object originalValue = field.get(original);
                Object replaceValue = field.get(replace);

                if (replaceValue != null) {
                    if (originalValue != null) {
                        if (field.getType().isAssignableFrom(originalValue.getClass())) {
                            // Recursively merge objects if they are of the same type
                            field.set(merged, merge(originalValue, replaceValue));
                        } else {
                            field.set(merged, replaceValue); // Replace if types are not compatible
                        }
                    } else {
                        field.set(merged, replaceValue); // Replace if original is null
                    }
                } else {
                    field.set(merged, originalValue); // Keep original if replace is null
                }
            }

            return merged;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return original; // Return the original object on error
        }
    }
}
