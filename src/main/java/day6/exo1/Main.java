package day6.exo1;

import utils.Parsing;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var parser = new Parsing();
//        String filename = "src/main/java/day6/inputs/inputsEasy.txt";
        String filename = "src/main/java/day6/inputs/inputs.txt";

        List<String> elements = parser.parseInlineTextFile(filename, ",");
        System.out.println(elements);

        List<Integer> startingFishs = elements.stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        System.out.println(startingFishs);

        Map<Integer, Integer> integerIntegerMap = startingFishs.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.toList(), List::size)));

        System.out.println(integerIntegerMap);

        for (int day = 0; day < 80; day++) {
            System.out.println("day" + day);
            Map<Integer, Integer> newMap = new HashMap<>(integerIntegerMap.size());
            integerIntegerMap.forEach((key, value) -> {
                if (key == 0) {
                    newMap.put(8, value + newMap.getOrDefault(8, 0));
                    newMap.put(6, value + newMap.getOrDefault(6, 0));
                } else {
                    newMap.put(key - 1, value + newMap.getOrDefault(key - 1, 0));
                }
            });
            integerIntegerMap = newMap;
            System.out.println(integerIntegerMap);
        }

        Integer answer = integerIntegerMap.values().stream().reduce(0, Integer::sum);
        System.out.println("answer : " + answer);
    }

}
