package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = scanner.nextInt();
        int[] inputs = new int[numberOfInputs];
        int min = 0;
        int temp = 0;

        for (int i = 0; i < numberOfInputs; i++) {
            inputs[i] = scanner.nextInt();
        }

        Arrays.sort(inputs);

        for (int i = 0; i < numberOfInputs; i++) {
            temp += inputs[i];

            min += temp;
        }

        System.out.println(min);
    }
}
