package acmicpc;

import java.io.*;

public class Problem_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] dp_table = new int[N][N];

        String[] input = br.readLine().split(" ");

        dp_table[0][0] = Integer.parseInt(input[0]);

        for (int i = 1; i < dp_table.length; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                dp_table[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = dp_table.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int temp = Math.max(dp_table[i][j], dp_table[i][j + 1]);

                dp_table[i - 1][j] += temp;
            }
        }

        bw.write(String.valueOf(dp_table[0][0]));


        bw.flush();
        bw.close();
    }
}
