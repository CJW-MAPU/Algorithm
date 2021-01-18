package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = scanner.nextInt();
        int[] input = new int[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            input[i] = scanner.nextInt();
        }

        Arrays.sort(input);

        for (int i = 0; i < numberOfLines; i++) {
            System.out.println(input[i]);
        }
    }
}
