package day5.utils;

import day5.exo1.Vent;
import day5.exo1.VentBoard;
import day5.exo1.VentLine;
import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

public class ParserToVentBoard extends Parsing {
    public VentBoard parseVentLinesFromFile(String filename){
        List<String> stringList = super.parseTextFile(filename);
        VentBoard ventBoard = new VentBoard();
        List<VentLine> ventLinesList = new ArrayList<>();

        for (String s :
                stringList) {
            String[] lineString = s.split(" -> |,");
            Vent startVent = new Vent(Integer.parseInt(lineString[0]),Integer.parseInt(lineString[1]));
            Vent endVent = new Vent(Integer.parseInt(lineString[2]),Integer.parseInt(lineString[3]));

            if (startVent.match(endVent)){
                VentLine ventLine = new VentLine(startVent, endVent);
                ventLinesList.add(ventLine);
            }
        }
        ventBoard.setVentLines(ventLinesList);
        return ventBoard;
    }
}
