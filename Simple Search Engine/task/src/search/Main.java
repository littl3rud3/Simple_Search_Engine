package search;

import java.io.File;

import java.io.FileWriter;

import java.util.*;


public class Main {
    static Map<Integer, String> people = new TreeMap<>();
    static Map<String, String> oof = new HashMap<>();

    public static void main(String[] args) {
        File file = new File(args[1].trim());
        try (Scanner scanner = new Scanner(file)) {
            int i = 0;
            while (scanner.hasNext()) {
                people.put(i, scanner.nextLine());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (var v : people.entrySet()) {
            for (String s : v.getValue().split(" ")) {
                if (oof.containsKey(s.toLowerCase())) oof.put(s.toLowerCase(), oof.get(s.toLowerCase()).concat(", " + v.getKey()));
                else oof.put(s.toLowerCase(), String.valueOf(v.getKey()));
            }
        }

        Perfomance.doSomething();

    }
}
