package search;

import java.util.*;

import static search.Main.*;

public class Perfomance {
    static Set<String> set = new LinkedHashSet<>();
    public static void doSomething() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

            int option = Integer.parseInt(sc.nextLine());
            if (option == 0) {
                System.out.println("Bye!");
                break;
            } else {
                switch (option) {
                    case 1:

                        System.out.println("Select a matching strategy: ALL, ANY, NONE");
                        String strategy = sc.nextLine();
                        choose(strategy);
                        break;
                    case 2:
                        for (var v : people.values()) {
                            System.out.println(v);
                        }
                        break;
                    default:
                        System.out.println("Incorrect option! Try again.");
                        break;
                }
            }
        }
    }
    public static void choose(String strategy) {
        Scanner sc = new Scanner(System.in);
        switch (strategy) {
            case "ANY":
                int sum = 0;
                System.out.println("Enter a name or email to search all suitable people.");
                String query = sc.nextLine();
                for (String s : query.split(" ")) {
                    if (oof.containsKey(s)) {
                        if (oof.get(s).contains(", ")) {
                            sum += oof.get(s).split(", ").length;
                            for (String ss : oof.get(s).split(", ")) {
                                set.add(people.get(Integer.parseInt(ss)));
                            }
                        } else {
                            set.add(people.get(Integer.parseInt(oof.get(query).trim())));
                        }
                    } else continue;

                }
                if (set.size() != 0) {
                    System.out.println(sum + " persons found:");
                    set.stream().forEach(System.out::println);
                    sum = 0;
                    set.clear();
                } else System.out.println("No matching people found.");
                break;
            case "ALL":
                Set<String> se = new LinkedHashSet<>();
                System.out.println("Enter a name or email to search all suitable people.");
                int match = 0;
                String query1 = sc.nextLine();
                for (var v : people.values()) {
                    if (v.matches(".*" + query1 + ".*")) {
                        match++;
                        se.add(v);
                    }
                }
                if (se.size() != 0) se.stream().forEach(System.out::println);
                else System.out.println("No matching people found.");
                break;
            case "NONE":
                Set<Integer> numbers = new LinkedHashSet<>();
                for (int i = 0; i < people.size(); i++) {
                    numbers.add(i);
                }
                Map<Integer, String> copy = new TreeMap<>(people);
                Set<Integer> set1 = new LinkedHashSet();
                int sum1 = 0;
                System.out.println("Enter a name or email to search all suitable people.");
                String query2 = sc.nextLine();
                for (String s : query2.split(" ")) {
                    if (oof.containsKey(s)) {
                        if (oof.get(s).contains(", ")) {
                            for (String v : oof.get(s).split(", ")){
                                numbers.remove(Integer.parseInt(v));
                            }
                        }
                    }
                }
                if (numbers.size() != people.size()) {
                    System.out.println(numbers.size() + " persons found:");
                    for (Integer i : numbers) {
                        System.out.println(people.get(i));
                    }
                } else System.out.println("No matching people found.");
                break;
            default:
                break;
        }
    }
}
