package utils;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {
    public static void initArray(int[] array) {
        Arrays.fill(array, 0);
    }

    public static boolean intIsInList(int element, List<Integer> array) {
        for (Integer integer : array) {
            if (element == integer) {
                return true;
            }
        }
        return false;
    }

    public static int sumOfListElements(List<Integer> list){
        int res = 0;
        for (Integer element :
                list) {
            res += element;
        }
        return res;
    }
}
