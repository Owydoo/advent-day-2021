package day3.exo1;

import utils.ArrayUtils;
import utils.Parsing;

import java.util.Arrays;
import java.util.List;

//https://adventofcode.com/2021/day/3
public class Main {
    public static void main(String[] args) {
        var parser = new Parsing();
        var arrayUtils = new ArrayUtils();
        String filename = "src/main/java/day3/inputs/inputs.txt";
        //String filename = "src/main/java/day3/inputs/inputEasy.txt";
        List<String> stringList = parser.parseTextFile(filename);

        int oneInputLength = stringList.get(0).length();

        int[] nbOfOneInEachBit = new int[oneInputLength];
        arrayUtils.initArray(nbOfOneInEachBit);
        findNbOfOneInEachBit(nbOfOneInEachBit, stringList, oneInputLength);

        int[] whichBitIsMoreCommonForEachBit = new int[oneInputLength];
        arrayUtils.initArray(whichBitIsMoreCommonForEachBit);
        findWhichBitIsMoreCommonForEachBit(whichBitIsMoreCommonForEachBit, nbOfOneInEachBit, stringList, oneInputLength);

        Answer answer = new Answer(0, 0, 0);
        answer = constructAnswer(whichBitIsMoreCommonForEachBit);

        System.out.println(answer);
        System.out.println(answer.getPowerConsumption());

    }

    private static Answer constructAnswer(int[] whichBitIsMoreCommonForEachBit) {
        String resInStr = "";
        Answer answer = new Answer(0, 0, 0);
        for (int i = 0; i < whichBitIsMoreCommonForEachBit.length; i++) {
            resInStr += String.valueOf(whichBitIsMoreCommonForEachBit[i]);
        }
        answer.setGammaRate(Integer.parseInt(resInStr, 2));

        Integer maxNumber = (int) Math.pow(2, whichBitIsMoreCommonForEachBit.length);

        answer.setEpsilonRate(maxNumber - answer.getGammaRate() - 1);

        answer.setPowerConsumption(answer.getEpsilonRate() * answer.getGammaRate());

        return answer;
    }


    private static void findWhichBitIsMoreCommonForEachBit(int[] whichBitIsMoreCommonForEachBit, int[] nbOfOneInEachBit, List<String> stringList, int oneInputLength) {
        for (int i = 0; i < oneInputLength; i++) {
            if (nbOfOneInEachBit[i] > (stringList.size() / 2)) {
                whichBitIsMoreCommonForEachBit[i] = 1;
            }
        }
    }

    private static void findNbOfOneInEachBit(int[] nbOfOneInEachBit, List<String> stringList, int oneInputLength) {
        for (int line = 0; line < stringList.size(); line++) {
            String input = stringList.get(line);
            for (int column = 0; column < oneInputLength; column++) {
                if (input.charAt(column) == '1') {
                    nbOfOneInEachBit[column] += 1;
                }
            }
        }
    }


}
