package day2.exo1;

import day2.exo1.utils.ParserToInstruction;

import java.util.List;

public class Main {
    //https://adventofcode.com/2021/day/2
    public static void main(String[] args) {
        var parser2 = new ParserToInstruction();
        String filename = "src/main/java/day2/inputs/inputs-exo1.txt";
        List<Instruction> instructions = parser2.parseIntoInstructions(filename);


        Integer depth = 0;
        Integer horizontalPosition = 0;

        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            if (instruction.getDirection().equals(Instruction.Direction.FORWARD)) {
                horizontalPosition += instruction.getAmount();
            } else if (instruction.getDirection().equals(Instruction.Direction.DOWN)) {
                depth += instruction.getAmount();
            } else if (instruction.getDirection().equals(Instruction.Direction.UP)) {
                depth -= instruction.getAmount();
            }
        }
        System.out.println(depth * horizontalPosition);
    }
}
