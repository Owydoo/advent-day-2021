package day5.exo2;

import day5.exo1.VentBoard;
import day5.utils.ParserToVentBoard;

public class Main {
    public static void main(String[] args) {
        var parserToVentBoard = new ParserToVentBoard();
        String filename = "src/main/java/day5/inputs/inputs.txt";
//        String filename = "src/main/java/day5/inputs/inputsEasy.txt";

        VentBoard ventBoard = parserToVentBoard.parseVentLinesFromFile(filename, true);
        System.out.println("ventBoard : " + ventBoard);

        int nbPointsWhereAtLeastTwoVents = ventBoard.findNbPointsWhereAtLeastTwoVentsOverlap();
        System.out.println("number of points where at least two lines overlap in VentBoard : " + nbPointsWhereAtLeastTwoVents);
    }
}
