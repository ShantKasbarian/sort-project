package org.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class FailCasesTests {
    private Sort sort = new Sort();
    private final String[] array;

    public FailCasesTests(String[] array) {
        this.array = array;
    }

    @Parameterized.Parameters
    public static List<Object[][]> params() {
        return Arrays.asList(new Object[][][] {
                null, // null case
                new String[][]{new String[]{}}, // empty case
                new String[][]{new String[]{"1", "2", "3", "4", "5"}}, // length < 10
                new String[][]{new String[]{"1", "2", "3", "3", "4", "5", "6", "7", "8", "9"}}, // duplicates
                new String[][]{new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}}, // num <= 0
                new String[][]{new String[]{"11", "0", "5", "7", "9", "8", "6", "10", "3", "2"}}, // num > 10
                new String[][]{new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}}, // length > 10
                new String[][]{new String[]{"1", "2", "3a", "4", "5", "6", "7", "8", "9", "10"}}, // lowercase letter
                new String[][]{new String[]{"1", "2", "3", "4A", "5", "6", "7", "8", "9", "10"}}, // uppercase letter
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCaseTest() {
        sort.sort(array);
    }
}
