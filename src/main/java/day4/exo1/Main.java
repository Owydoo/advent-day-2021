package day4.exo1;

import day4.utils.BingoParser;
import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var parser = new Parsing();
        var bingoParser = new BingoParser();
//        String filename = "src/main/java/day4/inputs/inputs.txt";
        String filename = "src/main/java/day4/inputs/inputsEasy.txt";

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
        System.out.println("winning board : "+winningBoard);

    }

    private static BingoBoard beginBingoGame(List<Integer> bingoInputs, List<BingoBoard> bingoBoards) {
        List<Integer> readInputs = new ArrayList<>();
        for (int input :
                bingoInputs) {
            readInputs.add(input);
            BingoBoard winningBoard = checkIfOneBoardWinning(readInputs, bingoBoards);
            if (winningBoard != null) {
                return winningBoard;
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
