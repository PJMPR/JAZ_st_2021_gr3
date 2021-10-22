package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ObjectPropertyProvider {

    /**
     * @param clazz
     * @return //    Metoda do wybierania „getterów”
     * //    Public
     * //    Zaczyna się od get lub is (w wypadku boolean)
     * //    Bez parametrów
     * //    Zwraca pole pod które jest podpięta
     */

    public List<Method> getPublicGetters(Class<?> clazz) {

        Predicate<Method> startWithGetorIs = x -> x.getName().startsWith("get") || x.getName().startsWith("is");
        Predicate<Method> isPublic = x -> Modifier.isPublic(x.getModifiers());
        Predicate<Method> parameterCount0 = x -> x.getParameterCount() == 0;
        Predicate<Method> returnNotVoidType = x -> !x.getReturnType().equals(Void.TYPE);

        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(startWithGetorIs)
                .filter(isPublic)
                .filter(parameterCount0)
                .filter(returnNotVoidType)
                .toList();

    }

    /**
     *
     * @param clazz
     * @return
     *
     * //
     * //    Metoda do wybierania „setterów”
     * //    Public
     * //    Zaczyna się od set
     * //    Posiada tylko jeden parametr
     * //    Jest typu void
     * //
     * //    Pole „field” w klasie
     * //    Posiada getter lub seter lub oba
     */
    public List<Method> getPublicSetters(Class<?> clazz) {

        Predicate<Method> startWithSet = x -> x.getName().startsWith("set");
        Predicate<Method> isPublic = x -> Modifier.isPublic(x.getModifiers());

        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(startWithSet)
                .filter(isPublic)
                .toList();
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz) {

        return Arrays.stream(clazz.getDeclaredFields()).toList();

    }


}
