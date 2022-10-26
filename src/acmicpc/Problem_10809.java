package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[26];
        Arrays.fill(result,-1);

        String input = bufferedReader.readLine();

        char[] arr = input.toCharArray();
        int counter = 0;
        for (char item: arr) {
            if (result[(int) item - 97] == -1) {
                result[(int) item - 97] = counter++;
            } else {
                counter++;
            }
        }

        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
