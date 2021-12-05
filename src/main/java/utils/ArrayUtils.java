package utils;

import java.util.List;

public class ArrayUtils {
    public static void initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public static boolean elementIsInArray(int element, List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (element == array.get(i)){
                return true;
            }
        }
        return false;
    }
}
