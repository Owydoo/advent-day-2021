package day4.utils;

import day4.exo1.BingoBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BingoParser {
    public List<Integer> getBingoInputsFromFirstLine(String line) {
        List<Integer> ints = new ArrayList<>();
        String[] numbersStr = line.split(",");
        for (String num : numbersStr) {
            ints.add(Integer.parseInt(num));
        }
        return ints;
    }


    public List<BingoBoard> getAllBingoBoardsFromStringList(List<String> stringList) {
        List<BingoBoard> bingoBoards = new ArrayList<>();

        for (int i = 2; i < stringList.size(); i = i + 6) {
            int[][] bingoInts = new int[5][5];
            for (int j = 0; j < 5; j++) {

                //Delete first char if space
                System.out.println(String.format("i : %d, j : %d, stringList.get(i + j) : %s ", i, j,
                        stringList.get(i + j)));
                if (stringList.get(i + j).charAt(0) == ' ') {
                    stringList.set(i + j, stringList.get(i + j).substring(1));
                }
                String[] strings = stringList.get(i + j).split(" +");
                System.out.println(String.format("i : %d, j : %d, strings : %s", i, j, Arrays.toString(strings)));
                for (int k = 0; k < 5; k++) {
                    bingoInts[j][k] = Integer.parseInt(strings[k]);
                }
            }
            BingoBoard bingoBoard = new BingoBoard(bingoInts);
            bingoBoards.add(bingoBoard);
        }

        return bingoBoards;
    }
}
