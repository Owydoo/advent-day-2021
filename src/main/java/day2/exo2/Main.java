package day2.exo2;

import day2.exo1.Instruction;
import day2.exo1.utils.ParserToInstruction;

import java.util.List;

public class Main {
    //https://adventofcode.com/2021/day/2
    public static void main(String[] args) {
        var parser = new ParserToInstruction();
        String filename = "src/main/java/day2/inputs/inputs-exo1.txt";
        List<Instruction> instructions = parser.parseIntoInstructions(filename);

        Integer depth = 0;
        Integer horizontalPosition = 0;
        Integer aim = 0;

        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            if (instruction.getDirection().equals(Instruction.Direction.DOWN)) {
                //increase aim
                aim += instruction.getAmount();
            } else if (instruction.getDirection().equals(Instruction.Direction.UP)) {
                //decrease aim
                aim -= instruction.getAmount();
            } else if (instruction.getDirection().equals(Instruction.Direction.FORWARD)) {
                //calculate horizontalPosition
                horizontalPosition += instruction.getAmount();
                //calculate depth
                depth = depth + (instruction.getAmount() * aim);
            }
        }

        System.out.println("answer (depth * horizontalPosition) : " + depth * horizontalPosition);
    }
}

