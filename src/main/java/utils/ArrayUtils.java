package utils;

public class ArrayUtils {
    public static void initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public static boolean elementIsInArray(Integer element, int[] array) {
        for (int x :
                array) {
            if (x == element) {
                return true;
            }
        }
        return false;
    }
}
