package acmicpc;

import java.io.*;

public class Problem_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, array[i]);
        }

        long[] dp_table = new long[1000001];

        dp_table[1] = 1;
        dp_table[2] = 2;
        dp_table[3] = 4;

        for (int i = 4; i < max + 1; i++) {
            dp_table[i] = (dp_table[i - 1] + dp_table[i - 2] + dp_table[i - 3]) % 1000000009;
        }

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(dp_table[array[i]]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
