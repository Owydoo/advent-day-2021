package exo1;

import java.util.List;
import java.util.stream.Collectors;

public class Exo2Parser extends utils{
    public List<Instruction> parseIntoInstructions(String filename){
        List<String> stringList = super.parseTextFile(filename);

        List<Instruction> instructionSet = stringList.stream()
                .map(s -> {
                    String[] sTab = s.split(" ");
                    return new Instruction(sTab[0], sTab[1]);
                })
                .collect(Collectors.toList());

        return  instructionSet;
    }
}
