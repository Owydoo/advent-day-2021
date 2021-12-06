package day5.exo1;

import day5.utils.ParserToVentBoard;

public class Main {
    public static void main(String[] args) {
        var parserToVentBoard = new ParserToVentBoard();
//        String filename = "src/main/java/day5/inputs/inputs.txt";
        String filename = "src/main/java/day5/inputs/inputsEasy.txt";

        VentBoard ventBoard = parserToVentBoard.parseVentLinesFromFile(filename);
        System.out.println("ventBoard : " + ventBoard);

    }
}
