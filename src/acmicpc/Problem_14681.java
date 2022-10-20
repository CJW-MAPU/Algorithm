package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        int y = Integer.parseInt(bufferedReader.readLine());

        if (x < 0) {
            if (x * y < 0) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        } else {
            if (x * y < 0) {
                System.out.println(4);
            } else {
                System.out.println(1);
            }
        }
    }
}
