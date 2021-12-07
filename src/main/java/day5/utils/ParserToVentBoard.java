package day5.utils;

import day5.exo1.Vent;
import day5.exo1.VentBoard;
import day5.exo1.VentLine;
import utils.Parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserToVentBoard extends Parsing {
    private static Pattern pattern;
    private static Matcher matcher;

    public VentBoard parseVentLinesFromFile(String filename) {
        List<String> stringList = super.parseTextFile(filename);
        VentBoard ventBoard = new VentBoard();
        List<VentLine> ventLinesList = new ArrayList<>();

        int index = 0;
        int stringListSize = stringList.size();
        for (String s :
                stringList) {

            pattern = Pattern.compile("(?<x1>\\d+),(?<y1>\\d+) -> (?<x2>\\d+),(?<y2>\\d+)");
            matcher = pattern.matcher(s);
            matcher.matches();

            Vent startVent = new Vent(Integer.parseInt(matcher.group("x1")), Integer.parseInt(matcher.group(
                    "y1")));
            Vent endVent = new Vent(Integer.parseInt(matcher.group("x2")),
                    Integer.parseInt(matcher.group("y2")));

            System.out.println("parser loading : " + (index * 100) / stringListSize + " %");

            if (startVent.match(endVent)) {
                VentLine ventLine = new VentLine(startVent, endVent);
                ventLinesList.add(ventLine);
            }
            index += 1;
        }
        ventBoard.setVentLines(ventLinesList);
        return ventBoard;
    }
}
