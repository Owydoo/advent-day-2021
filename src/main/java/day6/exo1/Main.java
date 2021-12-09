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

        List<Long> startingFishs = elements.stream().map(e -> Long.parseLong(e)).collect(Collectors.toList());
        System.out.println(startingFishs);

        Map<Long, Long> integerIntegerMap = startingFishs.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.toList(), objects -> (long) objects.size())));

        System.out.println(integerIntegerMap);

        //80 days for exo1
        //256 days for exo2

        for (int day = 0; day < 256; day++) {
            System.out.println("day" + day);
            Map<Long, Long> newMap = new HashMap<>(integerIntegerMap.size());
            integerIntegerMap.forEach((key, value) -> {
                if (key == 0) {
                    newMap.put(8l, value + newMap.getOrDefault(8l, 0l));
                    newMap.put(6l, value + newMap.getOrDefault(6l, 0l));
                } else {
                    newMap.put(key - 1l, value + newMap.getOrDefault(key - 1l, 0l));
                }
            });
            integerIntegerMap = newMap;
            System.out.println(integerIntegerMap);
        }

        Long answer = integerIntegerMap.values().stream().reduce((long) 0, Long::sum);
        System.out.println("answer : " + answer);
    }

}
