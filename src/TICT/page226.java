package TICT;

import java.io.*;
import java.util.Arrays;

public class page226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] token = new int[N];
        int[] dp_table = new int[M + 1];
        Arrays.fill(dp_table, 10001);

        for (int i = 0; i < N; i++) {
            token[i] = Integer.parseInt(br.readLine());
        }

        dp_table[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = token[i]; j < M + 1; j++) {
                dp_table[j] = Math.min(dp_table[j], dp_table[j - token[i]] + 1);
            }
        }

        if (dp_table[M] == 10001) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(dp_table[M]));
        }

        bw.flush();
        bw.close();
    }
}
