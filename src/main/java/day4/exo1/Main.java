package day4.exo1;

import day4.utils.BingoParser;
import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

import static utils.ArrayUtils.sumOfListElements;
//https://adventofcode.com/2021/day/4
public class Main {
    public static int lastInput;
    public static List<Integer> readInputs = new ArrayList<>();

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
        System.out.println(bingoBoards);

        //lire un chiffre dans les inputs,
        //l'ajouter dans une liste des nombres validés
        //vérifier que chaque board n'est pas terminée

        BingoBoard winningBoard = beginBingoGame(bingoInputs, bingoBoards);
        System.out.println("winning board : " + winningBoard);
        System.out.println("last input : " + lastInput);

        List<Integer> unmarkedNumbers = findUnmarkedNumbers(winningBoard, readInputs);

        int sumOfUnmarkedNumbers = sumOfListElements(unmarkedNumbers);
        System.out.println("sumOfUnmarkedNumbers : " + sumOfUnmarkedNumbers);

        int answer = sumOfUnmarkedNumbers * lastInput;
        System.out.println("answer : " + answer);

    }

    private static List<Integer> findUnmarkedNumbers(BingoBoard winningBoard, List<Integer> readInputs) {
        List<Integer> res = new ArrayList<>();
        for (int line = 0; line < 5; line++) {
            for (int column = 0; column < 5; column++) {
                if (!readInputs.contains(winningBoard.getBoard()[line][column])) {
                    res.add(winningBoard.getBoard()[line][column]);
                }
            }
        }
        return res;
    }

    private static BingoBoard beginBingoGame(List<Integer> bingoInputs, List<BingoBoard> bingoBoards) {

        for (int input :
                bingoInputs) {
            readInputs.add(input);
            if (readInputs.size() >= 5) {

                lastInput = input;
                BingoBoard winningBoard = checkIfOneBoardWinning(readInputs, bingoBoards);
                if (winningBoard != null) {
                    return winningBoard;
                }
            }
        }
        //no board found with all inputs
        return null;
    }

    private static BingoBoard checkIfOneBoardWinning(List<Integer> readInputs, List<BingoBoard> bingoBoards) {
        for (BingoBoard b :
                bingoBoards) {
            if (b.isWon(readInputs)) {
                return b;
            }
        }
        //no board is winning
        return null;
    }
}
