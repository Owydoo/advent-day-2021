package day4.exo2;

import day4.exo1.BingoBoard;
import day4.utils.BingoParser;
import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

import static utils.ArrayUtils.sumOfListElements;

public class Main {
    public static int lastInput;
    public static List<Integer> readInputs = new ArrayList<>();
    public static List<BingoBoard> winningBoards = new ArrayList<>();

    public static void main(String[] args) {
        var parser = new Parsing();
        var bingoParser = new BingoParser();
        String filename = "src/main/java/day4/inputs/inputs.txt";
        //String filename = "src/main/java/day4/inputs/inputsEasy.txt";

        List<String> stringList = parser.parseTextFile(filename);

        String firstLine = stringList.get(0);
        List<Integer> bingoInputs = bingoParser.getBingoInputsFromFirstLine(firstLine);

        System.out.println(bingoInputs);

        List<BingoBoard> bingoBoards = bingoParser.getAllBingoBoardsFromStringList(stringList);
        System.out.println(bingoBoards);

        BingoBoard lastBingoBoardToWin = findLastBingoBoard(bingoInputs, bingoBoards);
        //System.out.println("winningBoards : " + winningBoards);
        System.out.println("lastBingoBoardToWin : " + lastBingoBoardToWin);
        System.out.println("last input : " + lastInput);

        List<Integer> unmarkedNumbers = lastBingoBoardToWin.findUnmarkedNumbers(readInputs);

        int sumOfUnmarkedNumbers = sumOfListElements(unmarkedNumbers);
        System.out.println("sumOfUnmarkedNumbers : " + sumOfUnmarkedNumbers);

        int answer = sumOfUnmarkedNumbers * lastInput;
        System.out.println("answer : " + answer);
    }

    private static BingoBoard findLastBingoBoard(List<Integer> bingoInputs, List<BingoBoard> bingoBoards) {
        for (int input :
                bingoInputs) {
            readInputs.add(input);
            if (readInputs.size() >= 5) {
                lastInput = input;
                //vérifier s'il y a des BingoBoard gagnantes
                List<BingoBoard> thisTurnWinningBoards = findCurrentTurnWinningBoards(readInputs, bingoBoards, winningBoards);
                if (!thisTurnWinningBoards.isEmpty()) {
                    for (BingoBoard bingoBoard :
                            thisTurnWinningBoards) {
                        //si oui, les ajouter à la liste des bingoBoards gagnantes.
                        winningBoards.add(bingoBoard);
                    }
                }
                //quand la taille de winningBoards est égale à la taille de bingoBoards
                if (winningBoards.size() == bingoBoards.size()) {
                    //alors on renvoie la dernière boards de winningBoards
                    return winningBoards.get(winningBoards.size() - 1);
                }
            }
        }
        return null;
    }

    /**
     * returns a list of winning BingoBoards that weren't in the winningBoards list before
     *
     * @param readInputs
     * @param bingoBoards
     * @param winningBoards
     * @return
     */
    private static List<BingoBoard> findCurrentTurnWinningBoards(List<Integer> readInputs, List<BingoBoard> bingoBoards, List<BingoBoard> winningBoards) {
        List<BingoBoard> res = new ArrayList<>();
        for (BingoBoard bingoBoard :
                bingoBoards) {
            if (bingoBoard.isWon(readInputs) && !winningBoards.contains(bingoBoard)) {
                res.add(bingoBoard);
            }
        }
        return res;
    }


}
