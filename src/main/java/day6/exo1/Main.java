package day6.exo1;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var parser = new Parsing();
        String filename = "src/main/java/day6/inputs/inputsEasy.txt";
//        String filename = "src/main/java/day6/inputs/inputs.txt";

        List<String> elements = parser.parseInlineTextFile(filename, ",");
        System.out.println(elements);

        List<Integer> startingFishs = elements.stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        System.out.println(startingFishs);
        System.out.println(startingFishs.get(1).getClass().getName());

        int nbDays = 18;
        List<Integer> endFishs = simulatingLanternFishs(startingFishs, nbDays);

        int answer = endFishs.size();
        System.out.println("answer" + answer);

    }

    private static List<Integer> simulatingLanternFishs(List<Integer> startingFishs, int nbDays) {
        List<Integer> res = startingFishs;
        if (nbDays == 0){
            return res;
        }
        else {
            res = countOneDay(startingFishs);
            return simulatingLanternFishs(res, nbDays--);
        }
    }

    private static List<Integer> countOneDay(List<Integer> startingFishs) {
        List<Integer> res = new ArrayList<>();
        for (Integer fish :
                startingFishs) {
            fish -= 1;
            if (fish == -1){
                fish = 6;
                int newFish = 8;
                res.add(newFish);
            }
            res.add(fish);
        }
        return res;
    }
}
