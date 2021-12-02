package day1.exo2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String file = "/home/developer/Documents/Repos_Persos/Java/advent-day-1/src/main/resources/inputs-exo2.txt";
        List<Window> dataListe = readInputsInFile(file);
        System.out.println(dataListe);
        System.out.println(getNbIncreaseInWindows(dataListe));
    }

    private static int getNbIncreaseInWindows(List<Window> windows) {
        Integer res = 0;
        Window previousElement = windows.get(0);
        for (int i = 1; i < windows.size(); i++) {
               if (windows.get(i).isMoreThan(previousElement)){
                   res = res +1;
               }
               previousElement = windows.get(i);
        }
        return res;
    }

    private static List<Window> readInputsInFile(String file) {
        String line;
        List<Integer> ints = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                ints.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return getWindowsFromInts(ints);
    }

    private static List<Window> getWindowsFromInts(List<Integer> ints) {
        List<Window> windows = new ArrayList<Window>();
        for (int i = 0; i < ints.size()-2; i++) {
            windows.add(new Window(ints.get(i), ints.get(i+1), ints.get(i+2)));
        }
        return windows;
    }
}
