package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bufferedReader.readLine());

        System.out.println(fact(input));
    }

    private static int fact(int a) {
        if (a == 0) {
            return 1;
        } else {
            return a * fact(a - 1);
        }
    }
}
