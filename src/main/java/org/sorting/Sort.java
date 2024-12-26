package org.sorting;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents array sorting method
 * 1 - array length should be 10
 * 2 - duplicates are not allowed
 * 3 - numbers less than 1 or greater than 10 are not allowed
 * 4 - array shouldn't be null
 * 5 - only numbers are allowed
 * */
public class Sort {
    public String sort(String[] array) {
        if (array == null || array.length != 10) {
            throw new IllegalArgumentException();
        }

        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher1;
        Matcher matcher2;

        for (int i = 0; i < array.length; i++) {
            matcher1 = pattern.matcher(array[i]);

            if (matcher1.find()) {
                throw new IllegalArgumentException();
            }

            int num1 = Integer.parseInt(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                matcher2 = pattern.matcher(array[j]);

                if (matcher2.find()) {
                    throw new IllegalArgumentException();
                }

                int num2 = Integer.parseInt(array[j]);

                if (
                        num1 <= 0 ||
                        num1 > 10 ||
                        num2 <= 0 ||
                        num2 > 10
                ) {
                    throw new IllegalArgumentException();
                }

                if (num1 == num2) {
                    throw new IllegalArgumentException();
                }

                if (num1 > num2) {
                    array[j] = String.valueOf(num1);
                    array[i] = String.valueOf(num2);
                }
            }
        }

        System.out.println(Arrays.toString(array));
        return Arrays.toString(array);
    }
}
