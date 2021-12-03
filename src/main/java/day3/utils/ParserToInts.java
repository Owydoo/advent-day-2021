package day3.utils;

import utils.Parsing;

import java.util.List;
import java.util.stream.Collectors;

public class ParserToInts extends Parsing {
    public List<Integer> parseToIntegers(String filename){
        List<String> stringList = super.parseTextFile(filename);

        List<Integer> integerList = stringList.stream()
                .map(s -> {
                    return Integer.parseInt(s);
                })
                .collect(Collectors.toList());

        return integerList;
    }
}
