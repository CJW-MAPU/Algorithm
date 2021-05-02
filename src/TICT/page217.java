package TICT;

import java.io.*;

public class page217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        int[] dp_table = new int[10001];

        for (int i = 2; i < X + 1; i++) {
            dp_table[i] = dp_table[i - 1] + 1;

            if (i % 2 == 0) {
                dp_table[i] = Math.min(dp_table[i], dp_table[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp_table[i] = Math.min(dp_table[i], dp_table[i / 3] + 1);
            }

            if (i % 5 == 0) {
                dp_table[i] = Math.min(dp_table[i], dp_table[i / 5] + 1);
            }
        }

        bw.write(String.valueOf(dp_table[X]));

        bw.flush();
        bw.close();
    }
}
