package com.upday.flattenarray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ApplicationTest {

    /**
     * Helper-method.
     *
     * @param list - flat list of Integers.
     * @return - array with the same objects.
     */
    private static Integer[] toArray(List<Integer> list) {
        return list.toArray(new Integer[list.size()]);
    }

    private Application application;

    @Before
    public void init() {
        application = new Application();
    }

    @Test
    public void testForNull() {
        Assert.assertNull(application.flattenNestedArray(null));
    }

    @Test
    public void testForEmptyArray() {
        Assert.assertArrayEquals(
                "Empty Array",
                new Integer[]{},
                toArray(application.flattenNestedArray(new Object[]{}))
        );
    }

    @Test
    public void testForNonNestedArray() {
        Assert.assertArrayEquals(
                "Flat Array",
                new Integer[]{1, 2, 3, 4, 5},
                toArray(application.flattenNestedArray(new Object[]{1, 2, 3, 4, 5}))
        );
    }

    @Test
    public void testForTwoLevelNestedArray() {
        Assert.assertArrayEquals(
                "A two level nested Array",
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
                toArray(application.flattenNestedArray(new Object[]{1, 2, new Object[]{3, 4, 5}, 6, 7}))
        );
    }

    @Test
    public void testForThreeLevelNestedArray() {
        Assert.assertArrayEquals(
                "A three level nested Array",
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
                toArray(application.flattenNestedArray(new Object[]{1, 2, new Object[]{3, new Object[]{4, 5}}, 6, 7}))
        );
    }

    @Test
    public void testForFourLevelNestedArray() {
        Assert.assertArrayEquals(
                "A four level nested Array",
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
                toArray(application.flattenNestedArray(new Object[]{1, 2, new Object[]{3, new Object[]{4, new Object[]{5}}}, 6, 7}))
        );
    }

    @Test
    public void testForFourLevelNestedArrayUseStream() {
        Assert.assertArrayEquals(
                "A four level nested Array",
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
                application.flattenNestedArrayUsingStream(new Object[]{1, 2, new Object[]{3, new Object[]{4, new Object[]{5}}}, 6, 7}).toArray()
        );
    }
}
