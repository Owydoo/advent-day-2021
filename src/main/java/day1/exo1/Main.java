package day1.exo1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://adventofcode.com/2021/day/1

    public static void main(String[] args) {
        String file = "src/main/java/day1/inputs/input.txt";
        Integer previousValue = -1;
        String line;
        Integer res = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                System.out.println("line : "+line);

                Integer lineInt = Integer.parseInt(line);
                if (previousValue != -1){
                    if (lineInt > previousValue){
                        res = res +1;
                    }
                }
                previousValue = lineInt;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("res : " + res);
    }
}
