package day4.exo1;

import day4.utils.BingoParser;
import utils.Parsing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var parser = new Parsing();
        var bingoParser = new BingoParser();
        String filename = "src/main/java/day4/inputs/inputs.txt";
//        String filename = "src/main/java/day4/inputs/inputsEasy.txt";

        List<String> stringList = parser.parseTextFile(filename);

        String firstLine = stringList.get(0);
        List<Integer> bingoInputs = bingoParser.getBingoInputsFromFirstLine(firstLine);

        System.out.println(bingoInputs);

        List<BingoBoard> bingoBoards = bingoParser.getAllBingoBoardsFromStringList(stringList);


    }
}
