package TICT;

import java.io.*;

public class page223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp_table = new int[1001];

        dp_table[1] = 1;
        dp_table[2] = 3;

        for (int i = 3; i < N + 1; i++) {
            dp_table[i] = (dp_table[i - 1] + 2 * dp_table[i - 2]) % 796796;
        }

        bw.write(String.valueOf(dp_table[N]));

        bw.flush();
        bw.close();
    }
}
