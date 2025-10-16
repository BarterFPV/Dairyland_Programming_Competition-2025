package Combinations.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class combinations {

    public static void printCombinations(int n, List<Integer> path) {
        if (n == 0) {
            System.out.println(String.join("+", path.stream().map(Object::toString).toArray(String[]::new)));
            return;
        }
        if (n < 0) {
            return;
        }

        for (int step : new int[]{1, 2, 3}) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(step);
            printCombinations(n - step, newPath);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nInput = scanner.nextInt();
        printCombinations(nInput, new ArrayList<>());
        scanner.close();
    }
}
