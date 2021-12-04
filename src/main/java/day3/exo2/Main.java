package day3.exo2;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //https://adventofcode.com/2021/day/3
    public static void main(String[] args) throws Exception {
        var parser = new Parsing();
        String filename = "src/main/java/day3/inputs/inputs.txt";
//        String filename = "src/main/java/day3/inputs/inputEasy.txt";

        List<String> stringList = parser.parseTextFile(filename);
        System.out.println(stringList);

        Answer answer = constructAnswer(stringList);
        System.out.println(answer);
    }

    private static Answer constructAnswer(final List<String> stringList) throws Exception {
        List<String> strings = stringList;

        List<String> resultOxygen = findResultOxygen(strings, 0);
        List<String> resultCO2 = findResultCO2(strings, 0);

        System.out.println(resultOxygen);

        int resOxygenInt = Integer.parseInt(resultOxygen.get(0), 2);
        int resCO2Int = Integer.parseInt(resultCO2.get(0), 2);

        return new Answer(resOxygenInt, resCO2Int, resCO2Int * resOxygenInt);
    }

    private static List<String> findResultCO2(List<String> strings, int i) throws Exception {
        if (strings.size() <= 1) {
            return strings;
        } else if (fewerOrEqualsZerosInPositionIndex(strings, i)) {
            //réduire strings de tous les éléments commençant par 0 en position i
            strings = keepWordsWithBitAtGivenIndex(strings, i, '0');

            return findResultCO2(strings, i + 1);
            //return findResultOxygen du nouveau strings avec i + 1
        } else if (!fewerOrEqualsZerosInPositionIndex(strings, i)) {
            strings = keepWordsWithBitAtGivenIndex(strings, i, '1');

            return findResultCO2(strings, i + 1);
        } else {
            throw new Exception("Problem with conditions.");
        }


    }

    private static boolean fewerOrEqualsZerosInPositionIndex(List<String> strings, int i) {
        int zeros = 0;
        for (int j = 0; j < strings.size(); j++) {
            if (strings.get(j).charAt(i) == '0') {
                zeros += 1;
            }
        }
        return zeros <= (strings.size() - zeros);
    }


    private static List<String> findResultOxygen(List<String> strings, int i) throws Exception {
        if (strings.size() <= 1) {
            return strings;
        } else if (moreOrEqualsOnesInPositionIndex(strings, i)) {
            //réduire strings de tous les éléments commençant par 0 en position i
            strings = keepWordsWithBitAtGivenIndex(strings, i, '1');

            return findResultOxygen(strings, i + 1);
            //return findResultOxygen du nouveau strings avec i + 1
        } else if (!moreOrEqualsOnesInPositionIndex(strings, i)) {
            strings = keepWordsWithBitAtGivenIndex(strings, i, '0');

            return findResultOxygen(strings, i + 1);
        } else {
            throw new Exception("Problem with conditions.");
        }

    }

    private static List<String> keepWordsWithBitAtGivenIndex(List<String> strings, int i, char bit) {
        List<String> res = new ArrayList<>();

        for (int j = 0; j < strings.size(); j++) {
            if (strings.get(j).charAt(i) == bit) {
                res.add(strings.get(j));
            }
        }
        return res;
    }

    private static boolean moreOrEqualsOnesInPositionIndex(List<String> strings, int i) {
        int ones = 0;
        for (int j = 0; j < strings.size(); j++) {
            if (strings.get(j).charAt(i) == '1') {
                ones += 1;
            }
        }
        return ones >= (strings.size() - ones);
    }


}
