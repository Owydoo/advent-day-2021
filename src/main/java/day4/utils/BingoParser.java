package day4.utils;

import day4.exo1.BingoBoard;

import java.util.ArrayList;
import java.util.List;

public class BingoParser {
    public List<Integer> getBingoInputsFromFirstLine(String line){
        List<Integer> ints = new ArrayList<>();
        String[] numbersStr = line.split(",");
        for (String num : numbersStr){
            ints.add(Integer.parseInt(num));
        }
        return ints;
    }


    public List<BingoBoard> getAllBingoBoardsFromStringList(List<String> stringList) {
        List<BingoBoard> bingoBoards = new ArrayList<>();

        BingoBoard curBingoBoard = new BingoBoard();
        for (int i = 2; i < stringList.size() ; i = i + 5) {
            String line1 = stringList.get(i);
            String line2 = stringList.get(i+1);
            String line3 = stringList.get(i+2);
            String line4 = stringList.get(i+3);
            String line5 = stringList.get(i+4);
            int[][] curBoard = new int[5][5];
            //TODO: instanciate bingoBoard
        }
        return null;
    }
}
