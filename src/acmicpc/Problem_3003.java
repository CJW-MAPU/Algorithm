package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputData = bufferedReader.readLine().split(" ");

        int[] input = new int[6];

        for (int i = 0; i < inputData.length; i++) {
            input[i] = Integer.parseInt(inputData[i]);
        }

        int[] array = {1, 1, 2, 2, 2, 8};

        for (int i = 0; i < input.length; i++) {
            System.out.print(array[i] - input[i] + " ");
        }
    }
}
