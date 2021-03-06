package day2.exo1.utils;

import day2.exo1.Instruction;
import utils.Parsing;

import java.util.List;
import java.util.stream.Collectors;

public class ParserToInstruction extends Parsing {
    public List<Instruction> parseIntoInstructions(String filename){
        List<String> stringList = super.parseTextFile(filename);

        List<Instruction> instructions = stringList.stream()
                .map(s -> {
                    String[] sTab = s.split(" ");
                    return new Instruction(sTab[0], sTab[1]);
                })
                .collect(Collectors.toList());

        return  instructions;
    }
}
