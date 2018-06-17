package com.upday.flattenarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    /**
     * Flattens an array of arbitrarily nested arrays of integers into
     * a flat array of integers. e.g. [[1,2,[3]],4] -> [1,2,3,4]
     *
     * @param nestedArray - array of objects (either plain integers or nested arrays of Integers)
     * @return - flat array of Integers
     */
    public List<Integer> flattenNestedArray(Object[] nestedArray) {

        if(nestedArray == null) return null;

        List<Integer> flattenedArray = new ArrayList<Integer>();

        for (Object element : nestedArray) {
            if(element instanceof Integer){
                flattenedArray.add((Integer) element);
            } else {
                flattenedArray.addAll(flattenNestedArray((Object[]) element));
            }
        }
        return flattenedArray;
    }

    public Stream<Object> flattenNestedArrayUsingStream(Object[] nestedArray) {
        return Arrays.stream(nestedArray)
                .flatMap(o -> o instanceof Object[]? flattenNestedArrayUsingStream((Object[])o): Stream.of(o));
    }
}
