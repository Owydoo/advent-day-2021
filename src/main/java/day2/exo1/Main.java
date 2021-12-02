package day2.exo1;

import day2.exo1.utils.Exo2Parser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var parser2 = new Exo2Parser();
        String filename = "/home/developer/Documents/Repos_Persos/Java/advent-day-2/src/main/resources/input1.txt";
        List<Instruction> instructions = parser2.parseIntoInstructions(filename);


        Integer depth = 0;
        Integer horizontalPosition = 0;

        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            if (instruction.getDirection().equals(Instruction.Direction.FORWARD)) {
                horizontalPosition += instruction.getAmount();
            }
            else if (instruction.getDirection().equals(Instruction.Direction.DOWN)){
                depth += instruction.getAmount();
            }
            else if (instruction.getDirection().equals(Instruction.Direction.UP)){
                depth -= instruction.getAmount();
            }
        }

        System.out.println(depth * horizontalPosition);

    }

}
