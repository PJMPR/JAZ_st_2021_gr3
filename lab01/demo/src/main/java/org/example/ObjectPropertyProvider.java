package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public static boolean isGetter(final Method method) {
        if (!method.getName().startsWith("get") && !method.getName().startsWith("is")) return false;
        if (method.getParameterTypes().length != 0) return false;
        return !void.class.equals(method.getReturnType());
    }

    public static boolean isSetter(final Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (!void.class.equals(method.getReturnType())) return false;
        return method.getParameterTypes().length == 1;
    }

    public List<Method> getPublicGetters(final Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .filter(ObjectPropertyProvider::isGetter).toList();
    }


    public List<Method> getPublicSetters(final Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .filter(ObjectPropertyProvider::isSetter).toList();
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        final var getters = this.getPublicGetters(clazz)
                .stream()
                .map(Method::getName)
                .map(String::toUpperCase)
                .toList();

        final var setters = this.getPublicSetters(clazz)
                .stream()
                .map(Method::getName)
                .map(String::toUpperCase)
                .toList();

        final List<Field> filtered = new ArrayList<>();

        for (final var field : clazz.getDeclaredFields()) {
            final var fieldName = field.getName().replaceFirst("is", "").toUpperCase();

            var hasGetter = false;
            for (final var getter : getters) {
                if (getter.contains(fieldName)) {
                    hasGetter = true;
                    break;
                }
            }

            var hasSetter = false;
            for (final var setter : setters) {
                if (setter.contains(fieldName)) {
                    hasSetter = true;
                    break;
                }
            }

            if (!hasSetter && !hasGetter) {
                continue;
            }

            filtered.add(field);
        }

        return filtered;
    }
}
