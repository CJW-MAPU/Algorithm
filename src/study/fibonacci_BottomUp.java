package study;

import java.io.*;

public class fibonacci_BottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp_table = new long[100];

        dp_table[1] = 1;
        dp_table[2] = 1;

        for (int i = 3; i < 30; i++) {
            dp_table[i] = dp_table[i - 1] + dp_table[i - 2];
        }

        for (int i = 0; i < 30; i++) {
            bw.write(dp_table[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
