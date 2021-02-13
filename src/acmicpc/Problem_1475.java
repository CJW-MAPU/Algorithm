package acmicpc;

import java.io.*;

public class Problem_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        bw.write(findMinimumSet(input) + "");

        bw.flush();
        bw.close();
    }

    private static int findMinimumSet(String input) {
        int[] count = new int[9];

        for (int i = 0; i < input.length(); i++) {
            int temp = Integer.parseInt(String.valueOf(input.charAt(i)));

            if (temp == 6 || temp == 9) {
                count[6]++;
            } else {
                count[temp]++;
            }
        }

        if (count[6] % 2 == 1) {
            count[6] = (count[6] / 2) + 1;
        } else {
            count[6] /= 2;
        }

        int minimumSet = Integer.MIN_VALUE;

        for (int item : count) {
            if (minimumSet < item) {
                minimumSet = item;
            }
        }

        return minimumSet;
    }
}
